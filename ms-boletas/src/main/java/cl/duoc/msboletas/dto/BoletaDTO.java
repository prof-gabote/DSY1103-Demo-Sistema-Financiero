package cl.duoc.msboletas.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Representa una boleta en el sistema financiero")

@Data
public class BoletaDTO {

    @Schema(description = "Número de folio de la boleta", example = "F12345")
    @NotNull(message = "El número de folio es obligatorio.")
    private String folio;
    @Schema(description = "RUT del proveedor", example = "12.345.678-9")
    @NotNull(message = "El rut del proveedor es obligatorio.")
    private String rutProveedor;
    @Schema(description = "Glosa de la boleta", example = "Servicio de consultoría")
    @NotBlank(message = "La glosa es obligatoria.")
    private String glosa;
    @Schema(description = "Tipo de boleta", example = "Compra")
    private String tipo;
    @Schema(description = "Fecha de emisión de la boleta", example = "2023-10-01")
    @NotNull(message = "La fecha de emisión es obligatoria.")
    private LocalDate fecha;
    @Schema(description = "Monto bruto de la boleta", example = "100000")
    private int montoBruto; //Monto con IVA
    @Schema(description = "Monto neto de la boleta", example = "86956", minimum = "1")
    @Min(value = 1, message = "El monto neto no puede ser negativo ni 0.")
    private int montoNeto; //Monto sin IVA   
    @Schema(description = "Estado de la boleta", example = "Pendiente")
    private String estado; // Pendiente, Pagada, Anulada 
}
