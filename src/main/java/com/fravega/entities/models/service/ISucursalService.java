package com.fravega.entities.models.service;

import java.util.List;

import com.fravega.models.entities.Sucursal;

public interface ISucursalService {

	public List<Sucursal> findAll();

	public Sucursal findById(Long id);

	public Sucursal addSucursal(Sucursal sucursalNew);

	public String deleteSucursal(Long id);

	public String updateSucursal(Sucursal sucursalUpdate);

}
