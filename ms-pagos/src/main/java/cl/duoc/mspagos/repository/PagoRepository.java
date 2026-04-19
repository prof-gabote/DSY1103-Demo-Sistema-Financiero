package cl.duoc.mspagos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.mspagos.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

}
