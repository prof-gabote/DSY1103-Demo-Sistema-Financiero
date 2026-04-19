package cl.duoc.mspagos.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaPresupuestaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, precision = 14)
    private Long saldoDisponible;

    @Column(nullable = false, length = 20)
    private String estado;

    @OneToMany(mappedBy = "cuentaPresupuestaria")
    private List<Pago> pagos = new ArrayList<>();
}