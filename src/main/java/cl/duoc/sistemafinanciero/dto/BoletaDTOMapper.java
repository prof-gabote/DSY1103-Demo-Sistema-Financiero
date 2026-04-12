package cl.duoc.sistemafinanciero.dto;

import org.springframework.beans.factory.annotation.Autowired;

import cl.duoc.sistemafinanciero.model.Boleta;
import cl.duoc.sistemafinanciero.model.Proveedor;
import cl.duoc.sistemafinanciero.service.ProveedorService;

public class BoletaDTOMapper {

    @Autowired
    private static ProveedorService proveedorService;

    public static BoletaDTO toDTO(Boleta boleta) {
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

        return boletaDTO;
    }

    public static Boleta toModel(BoletaDTO boletaDTO) {
        if (boletaDTO == null) {
            return null;
        }

        Proveedor proveedor = proveedorService.findByRutProveedor(boletaDTO.getRutProveedor());

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
