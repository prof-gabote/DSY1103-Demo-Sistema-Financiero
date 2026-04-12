package cl.duoc.sistemafinanciero.model;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "boleta")
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String folio;
    private String rutProveedor;
    private String glosa;
    private String tipo;
    private LocalDate fechaEmision;
    private int montoBruto; // Monto con IVA
    private int montoNeto; // Monto sin IVA
    private String estado;
}