package com.tfg.appAlquileres.mappers;

import org.mapstruct.Mapper;

import com.tfg.appAlquileres.dtos.HerramientaDTO;
import com.tfg.appAlquileres.models.Herramienta;

@Mapper(componentModel = "spring")
public interface HerramientaMapper {
    Herramienta toEntity(HerramientaDTO dto);
    HerramientaDTO toDto(Herramienta herramienta);
}