package cl.duoc.mspagos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoRequestDTO {

    @NotBlank(message = "El folio de la boleta es obligatorio.")
    private String folio;
    @NotBlank(message = "El medio de pago es obligatorio.")
    private Long idMedioPago;
    @NotBlank(message = "La cuenta presupuestaria es obligatoria.")
    private Long idCtaPsto;

}
