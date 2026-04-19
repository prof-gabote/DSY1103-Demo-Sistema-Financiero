package cl.duoc.mspagos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.duoc.mspagos.dto.BoletaResponseDTO;

@FeignClient(name = "boleta-service", url = "http://localhost:8080/api/v1/boletas")
public interface BoletaClient {

    @GetMapping("/{folio}")
    BoletaResponseDTO obtenerBoletaPorFolio(@PathVariable("folio") String folio);

    @PutMapping("/estados")
    void actualizarEstadoBoleta(@RequestParam("folio") String folioBoleta, @RequestParam("estado") String estado);

}
