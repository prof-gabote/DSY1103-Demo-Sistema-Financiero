package cl.duoc.sistemafinanciero.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.duoc.sistemafinanciero.repository.BoletaRepository;
import jakarta.transaction.Transactional;
import cl.duoc.sistemafinanciero.dto.BoletaDTO;
import cl.duoc.sistemafinanciero.dto.BoletaDTOMapper;
import cl.duoc.sistemafinanciero.exceptions.RecursoNoEncontradoException;
import cl.duoc.sistemafinanciero.exceptions.RecursoYaExisteException;
import cl.duoc.sistemafinanciero.model.Boleta;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

@Transactional
public class BoletaService {

    private final BoletaRepository boletaRepository;
    private final BoletaDTOMapper boletaDTOMapper;

    public List<BoletaDTO> obtenerTodasLasBoletas() {

        List<Boleta> boletas = boletaRepository.findAll();
        List<BoletaDTO> boletaDTOs = new ArrayList<>();

        if (boletas.isEmpty()) {
            throw new RecursoNoEncontradoException("No se encontraron boletas.");
        }

        boletaDTOs = boletas.stream()
            .map(boletaDTOMapper::toDTO)
                .toList();

        return boletaDTOs;
    }

    public BoletaDTO obtenerBoletaPorFolio(String folio) {

        Boleta boleta = boletaRepository.findByFolio(folio);

        if (boleta == null) {
            throw new RecursoNoEncontradoException("Boleta no encontrada.");
        }

        return boletaDTOMapper.toDTO(boleta);

    }

    public boolean agregarBoleta(BoletaDTO boletaDTO) {

        if(boletaRepository.existsByFolio(boletaDTO.getFolio())) {
            throw new RecursoYaExisteException("Ya existe una boleta con el mismo número de folio.");
        }

        Boleta boleta = boletaDTOMapper.toModel(boletaDTO);
        return boletaRepository.save(boleta) != null;
    }

    public boolean actualizarBoleta(String folio, BoletaDTO boletaDTOActualizada) {

        Boleta boletaExistente = boletaRepository.findByFolio(folio);
        if (boletaExistente == null || !boletaExistente.getFolio().equals(folio)) {
            throw new RecursoNoEncontradoException("Número de folio incorrecto.");
        }

        Boleta boletaActualizada = boletaDTOMapper.toModel(boletaDTOActualizada);
        boletaActualizada.setId(boletaExistente.getId());
        return boletaRepository.save(boletaActualizada) != null;
    }

    public boolean eliminarBoleta(String folio) {

        if (!boletaRepository.existsByFolio(folio)) {
            throw new RecursoNoEncontradoException("Boleta no encontrada.");
        }

        boletaRepository.deleteByFolio(folio);
        return true;
    }

}
