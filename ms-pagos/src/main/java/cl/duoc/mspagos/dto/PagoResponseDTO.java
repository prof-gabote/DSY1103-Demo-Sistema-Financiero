package cl.duoc.mspagos.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagoResponseDTO {
    private Long idPago;
    private String estado;
    private String fechaSolicitud;
}
