package com.tfg.appAlquileres.models;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "herramienta")
public class Herramienta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nombre;

	private String descripcion;

	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal precioDia;

	@Column(nullable = false)
	private boolean disponible = true;

	@Column(nullable = false)
	private String categoria;
	
	@URL(message = "La URL de la imagen no es válida")
	private String imagenUrl;

}