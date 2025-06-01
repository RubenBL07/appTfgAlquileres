package com.tfg.appAlquileres.services;

import java.math.BigDecimal;
import java.util.Optional;

import com.tfg.appAlquileres.models.Cliente;


public interface ClienteService extends DataService<Cliente, Long>{
	boolean updateSaldo(Long id, BigDecimal nuevoSaldo);
	public Optional<Cliente> getByEmail(String email);
	

}
