package cl.duoc.msboletas.dto;

import org.springframework.stereotype.Component;

import cl.duoc.msboletas.model.Boleta;
import cl.duoc.msboletas.model.Proveedor;
import cl.duoc.msboletas.service.ProveedorService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BoletaDTOMapper {

    private final ProveedorService proveedorService;

    public BoletaDTO toDTO(Boleta boleta) {
        if (boleta == null) {
            return null;
        }

        BoletaDTO boletaDTO = new BoletaDTO();
        boletaDTO.setFolio(boleta.getFolio());
        boletaDTO.setRutProveedor(boleta.getProveedor().getRut());
        boletaDTO.setGlosa(boleta.getGlosa());
        boletaDTO.setTipo(boleta.getTipo());
        boletaDTO.setFecha(boleta.getFechaEmision());
        boletaDTO.setMontoBruto(boleta.getMontoBruto());
        boletaDTO.setMontoNeto(boleta.getMontoNeto());
        boletaDTO.setEstado(boleta.getEstado());

        return boletaDTO;
    }

    public Boleta toModel(BoletaDTO boletaDTO) {
        if (boletaDTO == null) {
            return null;
        }

        Proveedor proveedor = proveedorService.findByRut(boletaDTO.getRutProveedor());

        Boleta boleta = new Boleta();
        boleta.setFolio(boletaDTO.getFolio());
        boleta.setProveedor(proveedor);
        boleta.setGlosa(boletaDTO.getGlosa());
        boleta.setTipo(boletaDTO.getTipo());
        boleta.setFechaEmision(boletaDTO.getFecha());
        boleta.setMontoBruto(boletaDTO.getMontoBruto());
        boleta.setMontoNeto(boletaDTO.getMontoNeto());
        boleta.setEstado("PENDIENTE");

        return boleta;
    }

}
