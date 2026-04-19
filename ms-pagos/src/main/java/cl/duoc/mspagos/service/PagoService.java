package cl.duoc.mspagos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.duoc.mspagos.clients.BoletaClient;
import cl.duoc.mspagos.dto.BoletaResponseDTO;
import cl.duoc.mspagos.dto.PagoRequestDTO;
import cl.duoc.mspagos.model.CuentaPresupuestaria;
import cl.duoc.mspagos.model.MedioPago;
import cl.duoc.mspagos.model.Pago;
import cl.duoc.mspagos.repository.PagoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;
    private final BoletaClient boletaClient;
    private final MedioPagoService medioPagoService;
    private final CuentaPresupuestariaService cPstoService;

    public Pago crearPago(PagoRequestDTO pagoDTO) {

        BoletaResponseDTO boleta = boletaClient.obtenerBoletaPorFolio(pagoDTO.getFolio());

        if (boleta == null) {
            throw new IllegalArgumentException("Boleta no encontrada");
        }

        if ("ANULADA".equalsIgnoreCase(boleta.getEstado())) {
            throw new IllegalStateException("No se puede crear un pago para una boleta anulada");
        }

        if ("PAGADA".equalsIgnoreCase(boleta.getEstado())) {
            throw new IllegalStateException("No se puede crear un pago para una boleta ya pagada");
        }

        CuentaPresupuestaria cPsto = cPstoService.obtenerCuentaPresupuestariaPorId(pagoDTO.getIdCtaPsto());

        if (boleta.getMontoBruto() > cPsto.getSaldoDisponible()) {
            throw new IllegalStateException("El monto a pagar excede el saldo disponible de la cuenta presupuestaria");
        }

        MedioPago medioPago = medioPagoService.obtenerMedioPagoPorId(pagoDTO.getIdMedioPago());

        Pago pago = Pago.builder()
                .fechaPago(LocalDate.now())
                .montoPagado(boleta.getMontoBruto())
                .estado("INGRESADO")
                .folioBoleta(pagoDTO.getFolio())
                .rutProveedor(boleta.getRutProveedor())
                .descripcion(boleta.getGlosa())
                .medioPago(medioPago)
                .cuentaPresupuestaria(cPsto)
                .build();
        return pagoRepository.save(pago);
    }

    public Pago autorizarPago(Long id) {

        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pago no encontrado"));

        if (!"INGRESADO".equalsIgnoreCase(pago.getEstado())) {
            throw new IllegalStateException("Solo se pueden autorizar pagos en estado INGRESADO");
        }

        pago.setEstado("AUTORIZADO");
        
        return pagoRepository.save(pago);
    }

    public Pago liquidarPago(Long id) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pago no encontrado"));

        if (!"AUTORIZADO".equalsIgnoreCase(pago.getEstado())) {
            throw new IllegalStateException("Solo se pueden liquidar pagos en estado AUTORIZADO");
        }

        pago.setEstado("LIQUIDADO");

        pagoRepository.save(pago);

        boletaClient.actualizarEstadoBoleta(pago.getFolioBoleta(), "PAGADA");
        
        return pago;
    }
}
