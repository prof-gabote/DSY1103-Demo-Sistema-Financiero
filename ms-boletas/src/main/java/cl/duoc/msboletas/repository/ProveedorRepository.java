package cl.duoc.msboletas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.msboletas.model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    Optional<Proveedor> findByRut(String rutProveedor);
    
}
