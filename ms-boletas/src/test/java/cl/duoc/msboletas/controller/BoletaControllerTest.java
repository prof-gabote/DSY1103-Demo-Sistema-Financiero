package cl.duoc.msboletas.controller;


import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

import cl.duoc.msboletas.dto.BoletaDTO;
import cl.duoc.msboletas.exceptions.RecursoNoEncontradoException;
import cl.duoc.msboletas.service.BoletaService;

@WebMvcTest(BoletaController.class)
public class BoletaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BoletaService boletaService;

    @Test
    void whenObtenerTodasLasBoletas_thenReturnOk() throws Exception {

        //GIVEN
        List<BoletaDTO> boletaDTOs = List.of(new BoletaDTO());

        //WHEN
        when(boletaService.obtenerTodasLasBoletas()).thenReturn(boletaDTOs);

        mockMvc.perform(get("/api/v1/boletas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void whenObtenerBoletaPorFolio_thenReturnOk() throws Exception {

        //GIVEN
        String folio = "1234";
        BoletaDTO boletaDTO = new BoletaDTO();
        boletaDTO.setFolio(folio);

        //WHEN
        when(boletaService.obtenerBoletaPorFolio(folio)).thenReturn(boletaDTO);

        mockMvc.perform(get("/api/v1/boletas/{folio}", folio))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.folio").value(folio));
    }

    @Test
    void whenObtenerBoletaPorFolio_thenReturnNotFound() throws Exception {

        //GIVEN
        String folio = "0000";

        //WHEN
        when(boletaService.obtenerBoletaPorFolio(folio)).thenThrow(new RecursoNoEncontradoException("Boleta no encontrada"));

        mockMvc.perform(get("/api/v1/boletas/{folio}", folio))
                .andExpect(status().isNotFound());
    }

    
}
