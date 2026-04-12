package cl.duoc.sistemafinanciero.service;

import org.springframework.stereotype.Service;

import cl.duoc.sistemafinanciero.exceptions.RecursoNoEncontradoException;
import cl.duoc.sistemafinanciero.model.Proveedor;
import cl.duoc.sistemafinanciero.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    
    private final ProveedorRepository proveedorRepository;

    public Proveedor findByRutProveedor(String rutProveedor) {
        if (rutProveedor == null || rutProveedor.isEmpty()){
            throw new IllegalArgumentException("El RUT del proveedor no puede ser nulo o vacío");
        }
        return proveedorRepository.findByRut(rutProveedor).orElseThrow(() -> new RecursoNoEncontradoException("Proveedor no encontrado"));
    }
}
