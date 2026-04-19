package cl.duoc.mspagos.service;

import org.springframework.stereotype.Service;

import cl.duoc.mspagos.model.MedioPago;
import cl.duoc.mspagos.repository.MedioPadoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MedioPagoService {

    private final MedioPadoRepository medioPadoRepository;

    public MedioPago obtenerMedioPagoPorId(Long id) {
        return medioPadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Medio de pago no encontrado"));
    }
}
