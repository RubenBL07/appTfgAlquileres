package com.tfg.appAlquileres.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.tfg.appAlquileres.dtos.HerramientaDTO;
import com.tfg.appAlquileres.models.Herramienta;

@Mapper(componentModel = "spring")
public interface HerramientaMapper {
    HerramientaDTO toDto(Herramienta herramienta);
    List<HerramientaDTO> toDtoList(List<Herramienta> herramientas);

}