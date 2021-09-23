package com.fravega.entities.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fravega.entities.models.dao.SucursalDao;
import com.fravega.models.entities.Sucursal;

@Service
public class SucursalServiceImpl implements ISucursalService {

	@Autowired
	private SucursalDao sucursalDao;

	@Override
	@Transactional(readOnly = true)
	public List<Sucursal> findAll() {
		return (List<Sucursal>) sucursalDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Sucursal findById(Long id) {
		return sucursalDao.findById(id).orElse(null);
	}

	@Override
	public Sucursal addSucursal(Sucursal sucursalNew) {
		if (sucursalNew != null) {
			return sucursalDao.save(sucursalNew);
		}
		return new Sucursal();
	}

	@Override
	public String deleteSucursal(Long id) {
		if (sucursalDao.findById(id).isPresent()) {
			sucursalDao.deleteById(id);
			return "Sucursal eliminada correctamente!";
		}
		return "ERROR! La sucursal no existe";
	}

	@Override
	public String updateSucursal(Sucursal sucursalUpdate) {
		Long num = sucursalUpdate.getId();
		if (sucursalDao.findById(num).isPresent()) {
			Sucursal sucursalToUpdate = new Sucursal();

			sucursalToUpdate.setId(sucursalToUpdate.getId());
			sucursalToUpdate.setDireccion(sucursalToUpdate.getDireccion());
			sucursalToUpdate.setHorarioAtencion(sucursalToUpdate.getHorarioAtencion());
			sucursalToUpdate.setLatitud(sucursalToUpdate.getLatitud());
			sucursalToUpdate.setLongitud(sucursalToUpdate.getLatitud());
			
			sucursalDao.save(sucursalToUpdate);

			return "Sucursal modificada!";
		}
		return "Error al modificar sucursal";
	}

}
