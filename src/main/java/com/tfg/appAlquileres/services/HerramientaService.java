package com.tfg.appAlquileres.services;

import java.util.List;

import com.tfg.appAlquileres.models.Herramienta;

public interface HerramientaService extends DataService<Herramienta, Long>{
	public List<Herramienta> getAllHerramientasActivas();
    
}