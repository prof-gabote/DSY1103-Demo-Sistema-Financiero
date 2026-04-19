package cl.duoc.mspagos.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaPago;

    @Column(nullable = false, precision = 12, scale = 2)
    private int montoPagado;

    @Column(nullable = false, length = 20)
    private String estado; // PENDIENTE, COMPLETADO, ANULADO

    @Column(nullable = false, length = 50)
    private String folioBoleta;

    @Column(nullable = false, length = 12)
    private String rutProveedor;

    @Column(length = 100)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_medio_pago", nullable = false)
    private MedioPago medioPago;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_presupuestaria", nullable = false)
    private CuentaPresupuestaria cuentaPresupuestaria;
}
