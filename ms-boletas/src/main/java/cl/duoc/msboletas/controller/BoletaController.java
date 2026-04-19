package cl.duoc.msboletas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<Void> agregarBoleta (@Valid @RequestBody BoletaDTO boletaDTO) {
        return ResponseEntity.created(null).build();
    }

    @PutMapping("")
    public ResponseEntity<BoletaDTO> actualizaBoleta (@Valid @RequestBody BoletaDTO boletaDTO) {
        return ResponseEntity.ok(boletaService.actualizarBoleta(boletaDTO));
    }

    @PutMapping("/estados")
    public ResponseEntity<BoletaDTO> actualizaEstadoBoleta (@RequestParam String folio, @RequestParam String estado) {
        return ResponseEntity.ok(boletaService.actualizarBoleta(folio, estado));
    }

    @DeleteMapping("/{folio}")
    public ResponseEntity<Void> eliminarBoleta (@PathVariable String folio) {
        boletaService.eliminarBoleta(folio);
        return ResponseEntity.noContent().build();
    }

}
