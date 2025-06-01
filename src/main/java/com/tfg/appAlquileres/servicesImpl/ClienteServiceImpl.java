package com.tfg.appAlquileres.servicesImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tfg.appAlquileres.models.Cliente;
import com.tfg.appAlquileres.repositories.ClienteRepository;
import com.tfg.appAlquileres.services.ClienteService;

import lombok.NonNull;

@Service
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public Optional<Cliente> getById(@NonNull Long id) {
		return this.clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> getAll() {
		return this.clienteRepository.findAll();
	}

	@Override
	public boolean save(@NonNull Cliente entity) {
		return this.clienteRepository.save(entity) != null;
	}

	public boolean update(Long id, Cliente entity) {
		return this.clienteRepository.findById(id).map(existingCliente -> {
			entity.setId(id);
			return save(entity);
		}).orElse(false);
	}

	@Override
	public boolean delete(@NonNull Long id) {
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		if (cliente.isPresent()) {
			this.clienteRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public Optional<Cliente> getByEmail(@NonNull String email) {
		return this.clienteRepository.findByEmail(email);
	}
	
	@Override
	public boolean updateSaldo(Long id, BigDecimal nuevoSaldo) {
		return clienteRepository.findById(id).map(cliente -> {
			cliente.setSaldo(nuevoSaldo);
			clienteRepository.save(cliente);
			return true;
		}).orElse(false);
	}

}
