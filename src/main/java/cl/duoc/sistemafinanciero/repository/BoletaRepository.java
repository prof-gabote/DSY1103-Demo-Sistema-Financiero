package cl.duoc.sistemafinanciero.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.duoc.sistemafinanciero.model.Boleta;

@Repository
public class BoletaRepository {

    private List<Boleta> boletasEnBd = new ArrayList<>();

    private BoletaRepository() {
        boletasEnBd.add(new Boleta(1, "1001", "76012345-6", "Compra de insumos de oficina", "AFECTA",
                LocalDate.of(2026, 1, 10), 119000, 100000, "PAGADA"));

        boletasEnBd.add(new Boleta(2, "1002", "77123456-7", "Servicio de mantención de equipos", "AFECTA",
                LocalDate.of(2026, 1, 12), 238000, 200000, "EMITIDA"));

        boletasEnBd.add(new Boleta(3, "1003", "78234567-8", "Compra de materiales eléctricos", "AFECTA",
                LocalDate.of(2026, 1, 15), 357000, 300000, "PENDIENTE"));

        boletasEnBd.add(new Boleta(4, "1004", "79345678-9", "Arriendo de sala de reuniones", "EXENTA",
                LocalDate.of(2026, 1, 18), 150000, 150000, "PAGADA"));

        boletasEnBd.add(new Boleta(5, "1005", "70456789-0", "Servicio de impresión de documentos", "AFECTA",
                LocalDate.of(2026, 1, 20), 59500, 50000, "ANULADA"));

        boletasEnBd.add(new Boleta(6, "1006", "71567890-1", "Compra de artículos de aseo", "AFECTA",
                LocalDate.of(2026, 1, 22), 95200, 80000, "EMITIDA"));

        boletasEnBd.add(new Boleta(7, "1007", "72678901-2", "Capacitación interna de personal", "EXENTA",
                LocalDate.of(2026, 1, 25), 300000, 300000, "PENDIENTE"));

        boletasEnBd.add(new Boleta(8, "1008", "73789012-3", "Compra de mobiliario", "AFECTA",
                LocalDate.of(2026, 2, 2), 714000, 600000, "PAGADA"));

        boletasEnBd.add(new Boleta(9, "1009", "74890123-4", "Soporte técnico mensual", "AFECTA",
                LocalDate.of(2026, 2, 5), 178500, 150000, "EMITIDA"));

        boletasEnBd.add(new Boleta(10, "1010", "75901234-5", "Asesoría contable externa", "EXENTA",
                LocalDate.of(2026, 2, 8), 450000, 450000, "PENDIENTE"));
    }

    public List<Boleta> findAll() {
        return boletasEnBd;
    }

    public Boleta findByFolio(String folio) {

        for (Boleta boleta : boletasEnBd) {
            if (boleta.getFolio().equals(folio)) {
                return boleta;
            }
        }

        return null;
    }

    public boolean save(Boleta boleta) {
        boleta.setId(boletasEnBd.size() + 1);
        return boletasEnBd.add(boleta);
    }

    public boolean update(int id,Boleta boleta) {

        for(Boleta boletaInterna : boletasEnBd) {
            if (boletaInterna.getId() == id) {
                boletaInterna.setFolio(boleta.getFolio());
                boletaInterna.setRutProveedor(boleta.getRutProveedor());
                boletaInterna.setGlosa(boleta.getGlosa());
                boletaInterna.setTipo(boleta.getTipo());
                boletaInterna.setFecha(boleta.getFecha());
                boletaInterna.setMontoBruto(boleta.getMontoBruto());
                boletaInterna.setMontoNeto(boleta.getMontoNeto());
                boletaInterna.setEstado(boleta.getEstado());
                return true;
            }
        }
        return false;
    }

    public boolean deleteByFolio(String folio) {
        for (Boleta boleta : boletasEnBd) {
            if (boleta.getFolio().equals(folio)) {
                return boletasEnBd.remove(boleta);
            }
        }
        return false;

    }


}
