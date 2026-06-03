package cl.duoc.msboletas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.msboletas.dto.BoletaDTO;
import cl.duoc.msboletas.service.BoletaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Boletas", description = "Operaciones relacionadas con las boletas en el sistema financiero")

@RestController
@RequestMapping("/api/v1/boletas")
@RequiredArgsConstructor
public class BoletaController {

    private final BoletaService boletaService;

    @Operation(summary = "Obtener todas las boletas", description = "Devuelve una lista de todas las boletas registradas en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de boletas obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping()
    public ResponseEntity<List<BoletaDTO>> obtenerTodasLasBoletas() {

        List<BoletaDTO> boletaDTOs = boletaService.obtenerTodasLasBoletas();

        return ResponseEntity.ok(boletaDTOs);
    }

    @Operation(summary = "Obtener boleta por folio", description = "Devuelve los detalles de una boleta específica según su folio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Boleta obtenida exitosamente"),
            @ApiResponse(responseCode = "404", description = "Boleta no encontrada")
    })
    @GetMapping("/{folio}")
    public ResponseEntity<BoletaDTO> obtenerBoletaPorFolio(
            @Parameter(description = "Número de folio de la boleta", example = "1234") @PathVariable String folio) {
        return ResponseEntity.ok(boletaService.obtenerBoletaPorFolio(folio));
    }

    @Operation(summary = "Agregar nueva boleta", description = "Crea una nueva boleta en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Boleta creada exitosamente"),
            @ApiResponse(responseCode = "409", description = "Boleta ya existe")
    })
    @PostMapping()
    public ResponseEntity<Void> agregarBoleta(@Valid @RequestBody BoletaDTO boletaDTO) {
        boletaService.agregarBoleta(boletaDTO);
        return ResponseEntity.created(null).build();
    }

    @Operation(summary = "Actualizar boleta", description = "Actualiza los datos de una boleta existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Boleta actualizada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Boleta no encontrada")
    })
    @PutMapping("")
    public ResponseEntity<BoletaDTO> actualizaBoleta(@Valid @RequestBody BoletaDTO boletaDTO) {
        return ResponseEntity.ok(boletaService.actualizarBoleta(boletaDTO));
    }

    @PutMapping("/estados")
    @Operation(summary = "Actualizar estado de boleta", description = "Actualiza el estado de una boleta existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estado de boleta actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Boleta no encontrada")
    })
    public ResponseEntity<BoletaDTO> actualizaEstadoBoleta(
            @Parameter(description = "Número de folio de la boleta", example = "1234") @RequestParam String folio,
            @Parameter(description = "Nuevo estado de la boleta", example = "PENDIENTE") @RequestParam String estado) {
        return ResponseEntity.ok(boletaService.actualizarBoleta(folio, estado));
    }

    @DeleteMapping("/{folio}")
    @Operation(summary = "Eliminar boleta", description = "Elimina una boleta existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Boleta eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Boleta no encontrada")
    })
    public ResponseEntity<Void> eliminarBoleta(
            @Parameter(description = "Número de folio de la boleta", example = "1234") @PathVariable String folio) {
        boletaService.eliminarBoleta(folio);
        return ResponseEntity.noContent().build();
    }

}
