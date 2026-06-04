package cl.duoc.msboletas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.duoc.msboletas.model.Proveedor;
import cl.duoc.msboletas.repository.ProveedorRepository;

@ExtendWith(MockitoExtension.class)
public class ProveedorServiceTest {

    //Mocks
    @Mock
    private ProveedorRepository repo;

    //Servicio por probar
    @InjectMocks
    private ProveedorService service;

    @Test
    void givenRutProveedor_whenFindByRut_thenReturnProveedor() {

        //GIVEN
        Proveedor proveedor = new Proveedor();
        proveedor.setRut("12345678-9");

        //WHEN
        when(repo.findByRut(proveedor.getRut())).thenReturn(Optional.of(proveedor));
        
        Proveedor resultado = service.findByRut(proveedor.getRut());

        //THEN
        assertNotNull(resultado);
        assertEquals(proveedor.getRut(), resultado.getRut());
        verify(repo, atMostOnce()).findByRut(proveedor.getRut());
    }

    @Test
    void givenNullRutProveedor_whenFindByRut_thenThrowIllegalArgumentException() {

        //GIVEN
        String rutProveedor = null;

        //WHEN AND THEN
        assertThrows(IllegalArgumentException.class, () -> service.findByRut(rutProveedor));
        verify(repo, atMostOnce()).findByRut(rutProveedor);
    }

    @Test
    void givenEmptyRutProveedor_whenFindByRut_thenThrowIllegalArgumentException() {

        //GIVEN
        String rutProveedor = "";

        //WHEN AND THEN
        assertThrows(IllegalArgumentException.class, () -> service.findByRut(rutProveedor));
        verify(repo, atMostOnce()).findByRut(rutProveedor);
    }

    @Test
    void givenNonExistingRutProveedor_whenFindByRut_thenThrowRecursoNoEncontradoException() {

        //GIVEN
        String rutProveedor = "12345678-9";

        //WHEN
        when(repo.findByRut(rutProveedor)).thenReturn(Optional.empty());

        //THEN
        assertThrows(cl.duoc.msboletas.exceptions.RecursoNoEncontradoException.class, () -> service.findByRut(rutProveedor));
        verify(repo, atMostOnce()).findByRut(rutProveedor);
    }

}
