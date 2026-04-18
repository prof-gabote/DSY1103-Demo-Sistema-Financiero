package cl.duoc.msboletas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.msboletas.model.Boleta;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Long> {

    Boleta findByFolio(String folio);

    void deleteByFolio(String folio);

    boolean existsByFolio(String folio);
}