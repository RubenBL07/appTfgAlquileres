package com.tfg.appAlquileres.dtos;

import java.math.BigDecimal;

public record HerramientaDTO (
		Long id,
	    String nombre,
	    String descripcion,
	    BigDecimal precioDia,
	    boolean disponible,
	    String categoria,
	    String imagenUrl){
}
