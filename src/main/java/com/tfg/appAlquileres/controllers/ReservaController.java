package com.tfg.appAlquileres.controllers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.appAlquileres.dtos.ReservaDTO;
import com.tfg.appAlquileres.mappers.ReservaMapper;
import com.tfg.appAlquileres.models.Reserva;
import com.tfg.appAlquileres.servicesImpl.ReservaServiceImpl;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

	@Autowired
	private ReservaServiceImpl reservaServiceImpl;
	
    private final DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

	@Autowired
	private ReservaMapper reservaMapper;

	@GetMapping("findAll")
	public ResponseEntity<List<ReservaDTO>> get() {
		List<Reserva> reservas = reservaServiceImpl.getAll();
		return ResponseEntity.ok(reservaMapper.toDtoList(reservas));
	}

	@GetMapping("findById")
	public ResponseEntity<ReservaDTO> getById(@RequestParam Long id) {
		Reserva reserva = reservaServiceImpl.getById(id).orElse(null);
		return ResponseEntity.ok(reservaMapper.toDto(reserva));
	}

	@GetMapping("findByClienteId")
	public ResponseEntity<List<ReservaDTO>> getByClienteId(@RequestParam Long clienteId) {
		List<Reserva> reservas = reservaServiceImpl.getByClienteId(clienteId);
		return ResponseEntity.ok(reservaMapper.toDtoList(reservas));
	}

	@DeleteMapping("delete")
	public ResponseEntity<Boolean> delete(@RequestParam Long id) {
		return ResponseEntity.ok(reservaServiceImpl.delete(id));
	}

	@PostMapping("create")
	public ResponseEntity<Boolean> post(@RequestBody Reserva reserva) {
		return ResponseEntity.ok(reservaServiceImpl.save(reserva));
	}

	@PutMapping("update")
	public ResponseEntity<Boolean> put(@RequestParam Long id, @RequestBody Reserva reserva) {
		return ResponseEntity.ok(reservaServiceImpl.update(id, reserva));
	}

	@PutMapping("finalizar")
	public ResponseEntity<Boolean> finalizarReserva(@RequestParam Long id, @RequestParam String fechaFin,
			@RequestParam BigDecimal precioTotal) throws Exception {
		try {
            LocalDateTime fechaFinParsed = LocalDateTime.parse(fechaFin, fmt);
            boolean ok = reservaServiceImpl.finalizarReserva(id, fechaFinParsed, precioTotal);

            if (ok) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.badRequest().body(false);
            }
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(false);
        }
	}

}