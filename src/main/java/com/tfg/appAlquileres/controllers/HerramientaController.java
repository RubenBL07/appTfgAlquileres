package com.tfg.appAlquileres.controllers;

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

import com.tfg.appAlquileres.dtos.HerramientaDTO;
import com.tfg.appAlquileres.mappers.HerramientaMapper;
import com.tfg.appAlquileres.models.Herramienta;
import com.tfg.appAlquileres.servicesImpl.HerramientaServiceImpl;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientaController {
	
	@Autowired
	private HerramientaServiceImpl herramientaServiceImpl;
	
	@Autowired
	private HerramientaMapper herramientaMapper;

	@GetMapping("findAll")
	public ResponseEntity<List<Herramienta>> get() {
		return ResponseEntity.ok(herramientaServiceImpl.getAll());
	}

	@GetMapping("findById")
	public ResponseEntity<Herramienta> getById(@RequestParam Long id) {
		return ResponseEntity.ok(herramientaServiceImpl.getById(id).get());
	}

	@DeleteMapping("delete")
	public ResponseEntity<Boolean> delete(@RequestParam Long id) {
		return ResponseEntity.ok(herramientaServiceImpl.delete(id));
	}

	@PostMapping("create")
	public ResponseEntity<Boolean> post(@RequestBody Herramienta herramienta) {
		return ResponseEntity.ok(herramientaServiceImpl.save(herramienta));
	}

	@PutMapping("update")
	public ResponseEntity<Boolean> put(@RequestParam Long id, @RequestBody Herramienta herramienta) {
		return ResponseEntity.ok(herramientaServiceImpl.update(id, herramienta));
	}
	
	@GetMapping("findAllActivas")
    public ResponseEntity<List<HerramientaDTO>> getAllActivas() {
        List<Herramienta> lista = herramientaServiceImpl.getAllHerramientasActivas();
        return ResponseEntity.ok(herramientaMapper.toDtoList(lista));
    }

    @PutMapping("darDeBaja")
    public ResponseEntity<Boolean> darDeBaja(@RequestParam Long id) {
        return ResponseEntity.ok(herramientaServiceImpl.darDeBaja(id));
    }

}
