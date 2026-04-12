package cl.duoc.sistemafinanciero.model;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "boleta")
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 30)
    private String folio;
    // @Column(nullable = false, unique = true, length = 9)
    // private String rutProveedor;
    @Column(nullable = true, length = 9)
    private String glosa;
    @Column(nullable = false, length = 10)
    private String tipo;
    @Column(nullable = false)
    private LocalDate fechaEmision;
    @Column(nullable = false, precision = 12, scale = 2)
    private int montoBruto; // Monto con IVA
    @Column(nullable = false, precision = 12, scale = 2)
    private int montoNeto; // Monto sin IVA
    @Column(nullable = false, length = 10)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;
}