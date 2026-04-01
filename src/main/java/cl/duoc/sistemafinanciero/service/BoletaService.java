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

        // Debes implementar la lógica para obtener todas las boletas y convertirlas a DTOs

        return null;
    }

    public BoletaDTO obtenerBoletaPorFolio(String folio) {

        // Debes implementar la lógica para obtener una boleta por su número de folio y convertirla a DTO

        return null;

    }

    public boolean agregarBoleta(BoletaDTO boletaDTO) {

        // Debes implementar la lógica para agregar una nueva boleta utilizando el DTO proporcionado

        return false;
    }

    public boolean actualizarBoleta(String folio, BoletaDTO boletaDTOActualizada) {

        //Debes implementar la lógica para actualizar una boleta existente utilizando el número de folio y el DTO actualizado

        return false;
    }

    public boolean eliminarBoleta(String folio) {

        //Debes implementar la lógica para eliminar una boleta utilizando su número de folio

        return false;
    }
}
