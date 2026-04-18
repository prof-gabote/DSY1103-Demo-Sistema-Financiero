package cl.duoc.msboletas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.msboletas.dto.BoletaDTO;
import cl.duoc.msboletas.service.BoletaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/boletas")
@RequiredArgsConstructor
public class BoletaController {

    private final BoletaService boletaService;

    @GetMapping()
    public ResponseEntity<List<BoletaDTO>> obtenerTodasLasBoletas() {

        List<BoletaDTO> boletaDTOs = boletaService.obtenerTodasLasBoletas();

        return ResponseEntity.ok(boletaDTOs);
    }

    @GetMapping("/{folio}")
    public ResponseEntity<BoletaDTO> obtenerBoletaPorFolio(@PathVariable String folio) {
        return ResponseEntity.ok(boletaService.obtenerBoletaPorFolio(folio));
    }

    @PostMapping()
    public ResponseEntity<BoletaDTO> agregarBoleta (@Valid @RequestBody BoletaDTO boletaDTO) {
        boletaService.agregarBoleta(boletaDTO);
        return ResponseEntity.ok(boletaDTO);
    }

    @PutMapping("/{folio}")
    public ResponseEntity<BoletaDTO> actualizaBoleta (@PathVariable String folio, @Valid @RequestBody BoletaDTO boletaDTO) {
        boletaService.actualizarBoleta(folio, boletaDTO);
        return ResponseEntity.ok(boletaDTO);
    }

    @DeleteMapping("/{folio}")
    public ResponseEntity<Void> eliminarBoleta (@PathVariable String folio) {
        boletaService.eliminarBoleta(folio);
        return ResponseEntity.noContent().build();
    }

}
