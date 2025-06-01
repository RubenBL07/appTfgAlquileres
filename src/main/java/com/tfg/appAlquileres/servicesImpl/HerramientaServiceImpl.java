package com.tfg.appAlquileres.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tfg.appAlquileres.models.Herramienta;
import com.tfg.appAlquileres.repositories.HerramientaRepository;
import com.tfg.appAlquileres.services.HerramientaService;

import jakarta.transaction.Transactional;
import lombok.NonNull;

@Service
public class HerramientaServiceImpl implements HerramientaService {

	private final HerramientaRepository herramientaRepository;

	public HerramientaServiceImpl(HerramientaRepository herramientaRepository) {
		this.herramientaRepository = herramientaRepository;
	}

	@Override
	public Optional<Herramienta> getById(@NonNull Long id) {
		return this.herramientaRepository.findById(id);
	}

	@Override
	public List<Herramienta> getAll() {
		return this.herramientaRepository.findAll();
	}

	@Override
	public boolean save(@NonNull Herramienta entity) {
		return this.herramientaRepository.save(entity) != null;

	}

	@Override
	public boolean update(Long id, Herramienta entity) {
		return this.herramientaRepository.findById(id)
				.map(existingHerramienta -> {
					entity.setId(id); 
					return save(entity);
				}).orElse(false);

	}

	@Override
	public boolean delete(@NonNull Long id) {
		Optional<Herramienta> herramienta = this.herramientaRepository.findById(id);
		if (herramienta.isPresent()) {
			this.herramientaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
    public List<Herramienta> getAllHerramientasActivas() {
        return herramientaRepository.findByActivaTrue();
    }
	
	@Override
    public List<Herramienta> getAllHerramientasInactivas() {
        return herramientaRepository.findByActivaFalse();
    }

    @Transactional
    public boolean darDeBaja(Long id) {
        return herramientaRepository.findById(id).map(h -> {
            h.setActiva(false);
            herramientaRepository.save(h);
            return true;
        }).orElse(false);
    }
    
    @Transactional
    public boolean reactivar(Long id) {
        return herramientaRepository.findById(id).map(h -> {
            h.setActiva(true);
            herramientaRepository.save(h);
            return true;
        }).orElse(false);
    }

}