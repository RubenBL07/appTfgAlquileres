package com.tfg.appAlquileres.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.tfg.appAlquileres.dtos.ReservaDTO;
import com.tfg.appAlquileres.models.Reserva;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    ReservaDTO toDto(Reserva reserva);
    List<ReservaDTO> toDtoList(List<Reserva> reservas);

}