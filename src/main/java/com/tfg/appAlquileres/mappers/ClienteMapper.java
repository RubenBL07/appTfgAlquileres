package com.tfg.appAlquileres.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.tfg.appAlquileres.dtos.ClienteDTO;
import com.tfg.appAlquileres.models.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDto(Cliente cliente);
    List<ClienteDTO> toDtoList(List<Cliente> clientes);
}