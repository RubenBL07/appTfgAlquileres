package com.tfg.appAlquileres.dtos;

import java.math.BigDecimal;
import java.util.List;

public record ClienteDTO(Long id, String nombre, String email, String password, String direccion, BigDecimal saldo,
		List<ReservaDTO> reservas) {

}
