package cl.duoc.sistemafinanciero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.sistemafinanciero.model.Boleta;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Long> {

    List<Boleta> findAll();

    Boleta findByFolio(String folio);

    Boleta save(Boleta boleta);

    void deleteByFolio(String folio);
}