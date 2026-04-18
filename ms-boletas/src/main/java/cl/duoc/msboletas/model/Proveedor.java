package cl.duoc.msboletas.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true, length = 9)
    private String rut;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = true, length = 100)
    private String giro;
    @Column(nullable = true, length = 200)
    private String direccion;
    @Column(nullable = true, length = 20)
    private String telefono;

    @OneToMany(mappedBy = "proveedor")
    private List<Boleta> boletas;

}
