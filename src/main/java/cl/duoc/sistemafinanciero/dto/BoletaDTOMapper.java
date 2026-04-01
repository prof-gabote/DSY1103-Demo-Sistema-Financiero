package cl.duoc.sistemafinanciero.dto;

import cl.duoc.sistemafinanciero.model.Boleta;

public class BoletaDTOMapper {

    public static BoletaDTO toDTO(Boleta boleta) {
        if (boleta == null) {
            return null;
        }

        BoletaDTO boletaDTO = new BoletaDTO();
        boletaDTO.setFolio(boleta.getFolio());
        boletaDTO.setRutProveedor(boleta.getRutProveedor());
        boletaDTO.setGlosa(boleta.getGlosa());
        boletaDTO.setTipo(boleta.getTipo());
        boletaDTO.setFecha(boleta.getFecha());
        boletaDTO.setMontoBruto(boleta.getMontoBruto());
        boletaDTO.setMontoNeto(boleta.getMontoNeto());

        return boletaDTO;
    }

    public static Boleta toModel(BoletaDTO boletaDTO) {
        if (boletaDTO == null) {
            return null;
        }

        Boleta boleta = new Boleta();
        boleta.setFolio(boletaDTO.getFolio());
        boleta.setRutProveedor(boletaDTO.getRutProveedor());
        boleta.setGlosa(boletaDTO.getGlosa());
        boleta.setTipo(boletaDTO.getTipo());
        boleta.setFecha(boletaDTO.getFecha());
        boleta.setMontoBruto(boletaDTO.getMontoBruto());
        boleta.setMontoNeto(boletaDTO.getMontoNeto());

        return boleta;
    }

}
