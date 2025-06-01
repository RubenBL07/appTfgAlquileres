package com.tfg.appAlquileres.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.appAlquileres.dtos.ClienteDTO;
import com.tfg.appAlquileres.mappers.ClienteMapper;
import com.tfg.appAlquileres.models.Cliente;
import com.tfg.appAlquileres.servicesImpl.ClienteServiceImpl;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	@Autowired
	private ClienteMapper clienteMapper;	

	@GetMapping("findAll")
	public ResponseEntity<List<ClienteDTO>> get() {
        List<Cliente> clientes = clienteServiceImpl.getAll();
		return ResponseEntity.ok(clienteMapper.toDtoList(clientes));
	}

	@GetMapping("findById")
	public ResponseEntity<ClienteDTO> getById(@RequestParam Long id) {
		Cliente cliente = clienteServiceImpl.getById(id).orElse(null);
		return ResponseEntity.ok(clienteMapper.toDto(cliente));
	}
	
	@GetMapping("findByEmail")
	public ResponseEntity<ClienteDTO> getByEmail(@RequestParam String email) {
		Cliente cliente = clienteServiceImpl.getByEmail(email).orElse(null);
		return ResponseEntity.ok(clienteMapper.toDto(cliente));
	}

	@DeleteMapping("delete")
	public ResponseEntity<Boolean> delete(@RequestParam Long id) {
		return ResponseEntity.ok(clienteServiceImpl.delete(id));
	}

	@PostMapping("create")
	public ResponseEntity<Boolean> post(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(clienteServiceImpl.save(cliente));
	}

	@PutMapping("update")
	public ResponseEntity<Boolean> put(@RequestParam Long id, @RequestBody Cliente cliente) {
		return ResponseEntity.ok(clienteServiceImpl.update(id, cliente));
	}
	
	@PutMapping("/updateSaldo")
	public ResponseEntity<Boolean> actualizarSaldo(@RequestParam Long id, @RequestParam BigDecimal saldo) {
	    return ResponseEntity.ok(clienteServiceImpl.updateSaldo(id, saldo));
	}
	
	@GetMapping("/ping")
	public ResponseEntity<Boolean> ping() {
	    return ResponseEntity.ok(true);
	}

}
