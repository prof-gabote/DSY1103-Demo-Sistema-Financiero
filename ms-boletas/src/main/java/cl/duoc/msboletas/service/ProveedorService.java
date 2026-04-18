package cl.duoc.msboletas.service;

import org.springframework.stereotype.Service;

import cl.duoc.msboletas.exceptions.RecursoNoEncontradoException;
import cl.duoc.msboletas.model.Proveedor;
import cl.duoc.msboletas.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    
    private final ProveedorRepository proveedorRepository;

    public Proveedor findByRut(String rutProveedor) {
        if (rutProveedor == null || rutProveedor.isEmpty()){
            throw new IllegalArgumentException("El RUT del proveedor no puede ser nulo o vacío");
        }
        return proveedorRepository.findByRut(rutProveedor).orElseThrow(() -> new RecursoNoEncontradoException("Proveedor no encontrado"));
    }

}
