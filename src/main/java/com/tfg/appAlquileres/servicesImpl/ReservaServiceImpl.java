package com.tfg.appAlquileres.servicesImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.appAlquileres.enums.EstadoReserva;
import com.tfg.appAlquileres.models.Cliente;
import com.tfg.appAlquileres.models.Herramienta;
import com.tfg.appAlquileres.models.Reserva;
import com.tfg.appAlquileres.repositories.ClienteRepository;
import com.tfg.appAlquileres.repositories.HerramientaRepository;
import com.tfg.appAlquileres.repositories.ReservaRepository;
import com.tfg.appAlquileres.services.ReservaService;

import jakarta.transaction.Transactional;
import lombok.NonNull;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private HerramientaRepository herramientaRepository;

	@Override
	public Optional<Reserva> getById(@NonNull Long id) {
		return this.reservaRepository.findById(id);
	}

	@Override
	public List<Reserva> getAll() {
		return this.reservaRepository.findAll();
	}

	@Override
	public boolean save(@NonNull Reserva entity) {
		return this.reservaRepository.save(entity) != null;
	}

	@Override
	public boolean update(Long id, Reserva entity) {
		return this.reservaRepository.findById(id).map(existingReserva -> {
			entity.setId(id);
			return save(entity);
		}).orElse(false);

	}

	@Override
	public boolean delete(@NonNull Long id) {
		Optional<Reserva> reserva = this.reservaRepository.findById(id);
		if (reserva.isPresent()) {
			this.reservaRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Reserva> getByClienteId(@NonNull Long clienteId) {
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encotrado con id: " + clienteId));
		return this.reservaRepository.findByCliente(cliente);
	}

	@Transactional
	public boolean finalizarReserva(Long id, @NonNull LocalDateTime fechaFinCliente,
			@NonNull BigDecimal precioTotalCliente) throws Exception {
		Reserva reserva = reservaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Reserva no existe"));

		if (reserva.getEstado() != EstadoReserva.ACTIVA) {
			return false;
		}

		Cliente cliente = reserva.getCliente();
		if (cliente.getSaldo().compareTo(precioTotalCliente) < 0) {
			throw new Exception("Saldo insuficiente para finalizar la reserva");
		}

		reserva.setFechaFin(fechaFinCliente);
		reserva.setPrecioTotal(precioTotalCliente);
		reserva.setEstado(EstadoReserva.FINALIZADA);

		cliente.setSaldo(cliente.getSaldo().subtract(precioTotalCliente));

		Herramienta herramienta = reserva.getHerramienta();
		herramienta.setDisponible(true);

		clienteRepository.save(cliente);
		herramientaRepository.save(herramienta);
		reservaRepository.save(reserva);

		return true;
	}

}