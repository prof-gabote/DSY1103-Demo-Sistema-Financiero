package cl.duoc.sistemafinanciero.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.duoc.sistemafinanciero.repository.BoletaRepository;
import jakarta.transaction.Transactional;
import cl.duoc.sistemafinanciero.dto.BoletaDTO;
import cl.duoc.sistemafinanciero.dto.BoletaDTOMapper;
import cl.duoc.sistemafinanciero.exceptions.RecursoNoEncontradoException;
import cl.duoc.sistemafinanciero.model.Boleta;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

@Transactional
public class BoletaService {

    private final BoletaRepository boletaRepository;

    public List<BoletaDTO> obtenerTodasLasBoletas() {

        // Debes implementar la lógica para obtener todas las boletas y convertirlas a DTOs

        return null;
    }

    public BoletaDTO obtenerBoletaPorFolio(String folio) {

        // Debes implementar la lógica para obtener una boleta por su número de folio y convertirla a DTO

        return null;

    }

    public boolean agregarBoleta(BoletaDTO boletaDTO) {

        // Debes implementar la lógica para agregar una nueva boleta utilizando el DTO proporcionado

        Boleta boleta = BoletaDTOMapper.toModel(boletaDTO);
        return boletaRepository.save(boleta) != null;
    }

    public boolean actualizarBoleta(String folio, BoletaDTO boletaDTOActualizada) {

        //solo existe el metodo save para poder actualizar
        Boleta boletaExistente = boletaRepository.findByFolio(folio);
        if (boletaExistente == null || !boletaExistente.getFolio().equals(folio)) {
            throw new RecursoNoEncontradoException("Número de folio incorrecto.");
        }

        Boleta boletaActualizada = BoletaDTOMapper.toModel(boletaDTOActualizada);
        boletaActualizada.setId(boletaExistente.getId());
        return boletaRepository.save(boletaActualizada) != null;

    }

    public boolean eliminarBoleta(String folio) {

        //Debes implementar la lógica para eliminar una boleta utilizando su número de folio

        boletaRepository.deleteByFolio(folio);
        return true;
    }
}
