package com.tfg.appAlquileres.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;
	
	private String direccion;

	@Column(precision = 10, scale = 2)
	private BigDecimal saldo = BigDecimal.valueOf(1000.00);
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reserva> reservas = new ArrayList<>();

	public Cliente() {
	}

	public Cliente(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
	}

	public Cliente(String nombre, String email, String password) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}

	public Cliente(String nombre, String email, String password, String direccion) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.direccion = direccion;
	}

}
