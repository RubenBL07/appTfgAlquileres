package com.tfg.appAlquileres.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.appAlquileres.enums.EstadoReserva;
import com.tfg.appAlquileres.models.Cliente;
import com.tfg.appAlquileres.models.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByCliente(Cliente cliente);
    List<Reserva> findByEstado(EstadoReserva estado);
    
}