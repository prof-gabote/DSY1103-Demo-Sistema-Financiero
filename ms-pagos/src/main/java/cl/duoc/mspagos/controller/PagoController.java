package cl.duoc.mspagos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.mspagos.dto.PagoRequestDTO;
import cl.duoc.mspagos.dto.PagoResponseDTO;
import cl.duoc.mspagos.model.Pago;
import cl.duoc.mspagos.service.PagoService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @PostMapping("")
    public ResponseEntity<PagoResponseDTO> crearPago(@RequestBody PagoRequestDTO pagoDTO) {

        Pago pagoCreado = pagoService.crearPago(pagoDTO);

        PagoResponseDTO response = PagoResponseDTO.builder()
        .idPago(pagoCreado.getId())
        .estado(pagoCreado.getEstado())
        .fechaSolicitud(pagoCreado.getFechaPago().toString())
        .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/autorizar")
    public ResponseEntity<PagoResponseDTO> autorizarPago (@PathVariable Long id) {
        Pago pagoAutorizado = pagoService.autorizarPago(id);

        PagoResponseDTO response = PagoResponseDTO.builder()
        .idPago(pagoAutorizado.getId())
        .estado(pagoAutorizado.getEstado())
        .fechaSolicitud(pagoAutorizado.getFechaPago().toString())
        .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/liquidar")
    public ResponseEntity<PagoResponseDTO> liquidarPago (@PathVariable Long id) {
        Pago pagoLiquidado = pagoService.liquidarPago(id);

        PagoResponseDTO response = PagoResponseDTO.builder()
        .idPago(pagoLiquidado.getId())
        .estado(pagoLiquidado.getEstado())
        .fechaSolicitud(pagoLiquidado.getFechaPago().toString())
        .build();
        return ResponseEntity.ok(response);
    }
    

}
