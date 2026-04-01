package cl.duoc.sistemafinanciero.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boleta {
    private int id;
    private String folio;
    private String rutProveedor;
    private String glosa;
    private String tipo;
    private LocalDate fecha;
    private int montoBruto; // Monto con IVA
    private int montoNeto; // Monto sin IVA
    private String estado;
}