package com.tfg.appAlquileres.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.tfg.appAlquileres.enums.EstadoReserva;

public record ReservaDTO (
		Long id,
		LocalDateTime fechaInicio,
		LocalDateTime fechaFin,
		BigDecimal precioTotal,
		EstadoReserva estado,
		HerramientaDTO herramienta){}
    
