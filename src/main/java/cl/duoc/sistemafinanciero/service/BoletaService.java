package cl.duoc.sistemafinanciero.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.duoc.sistemafinanciero.repository.BoletaRepository;
import cl.duoc.sistemafinanciero.dto.BoletaDTO;
import cl.duoc.sistemafinanciero.dto.BoletaDTOMapper;
import cl.duoc.sistemafinanciero.exceptions.RecursoNoEncontradoException;
import cl.duoc.sistemafinanciero.model.Boleta;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoletaService {

    private final BoletaRepository boletaRepository;

    public List<BoletaDTO> obtenerTodasLasBoletas() {

        List<Boleta> boletas = boletaRepository.findAll();
        List<BoletaDTO> boletaDTOs = new ArrayList<>();

        if (!boletas.isEmpty()) {

            for (Boleta boleta : boletas) {
                boletaDTOs.add(BoletaDTOMapper.toDTO(boleta));
            }

        }

        return boletaDTOs;
    }

    public BoletaDTO obtenerBoletaPorFolio(String folio) {

        Boleta boleta = boletaRepository.findByFolio(folio);

        if (boleta == null || !boleta.getFolio().equals(folio)) {
            throw new RecursoNoEncontradoException("Número de folio incorrecto.");
        }

        return BoletaDTOMapper.toDTO(boleta);

    }

    public boolean agregarBoleta(BoletaDTO boletaDTO) {

        if (boletaDTO == null || boletaDTO.getFolio() == null || boletaDTO.getFolio().isEmpty()) {
            throw new IllegalArgumentException("La boleta o su número de folio no pueden ser nulos o vacíos.");
        }

        Boleta boleta = BoletaDTOMapper.toModel(boletaDTO);
        return boletaRepository.save(boleta);
    }

    public boolean actualizarBoleta(String folio, BoletaDTO boletaDTOActualizada) {

        if (boletaDTOActualizada == null || boletaDTOActualizada.getFolio() == null
                || boletaDTOActualizada.getFolio().isEmpty()) {
            throw new IllegalArgumentException(
                    "La boleta actualizada o su número de folio no pueden ser nulos o vacíos.");
        }

        Boleta boletaExistente = boletaRepository.findByFolio(folio);
        System.out.println("Boleta existente: " + boletaExistente);

        if (boletaExistente == null || !boletaExistente.getFolio().equals(folio)) {
            throw new RecursoNoEncontradoException("Número de folio incorrecto.");
        }

        return boletaRepository.update(boletaExistente.getId(), BoletaDTOMapper.toModel(boletaDTOActualizada));
    }

    public boolean eliminarBoleta(String folio) {

        Boleta boletaExistente = boletaRepository.findByFolio(folio);

        if (boletaExistente == null || !boletaExistente.getFolio().equals(folio)) {
            throw new RecursoNoEncontradoException("Número de folio incorrecto.");
        }

        return boletaRepository.deleteByFolio(folio);
    }
}
