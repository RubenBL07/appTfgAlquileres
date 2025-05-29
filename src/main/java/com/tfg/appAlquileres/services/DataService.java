package com.tfg.appAlquileres.services;

import java.util.List;
import java.util.Optional;

public interface DataService<T, ID> {
	public Optional<T> getById(ID id);

    public List<T> getAll();

    public boolean save(T entity);

    public boolean update(ID id, T entity);

    public boolean delete(ID id);
	

}
