package com.tfg.appAlquileres.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.appAlquileres.models.Herramienta;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {
    List<Herramienta> findByCategoriaAndDisponible(String categoria, boolean disponible);
}