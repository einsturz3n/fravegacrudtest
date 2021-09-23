package com.fravega.entities.models.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fravega.models.entities.Sucursal;

public interface SucursalDao extends CrudRepository<Sucursal, Long> {

	void save(Optional<Sucursal> sucursalToUpdate);
}
