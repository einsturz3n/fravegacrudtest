package com.fravega.entities.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fravega.entities.models.service.ISucursalService;
import com.fravega.models.entities.Sucursal;

@RestController
public class SucursalController {

	@Autowired
	private ISucursalService sucursalService;

	// http://localhost:8001/listar (GET)
	@GetMapping("/sucursales/listar")
	public List<Sucursal> listar() {
		return sucursalService.findAll();
	}

	// http://localhost:8001/ver/1 (GET)
	@GetMapping("/sucursales/ver/{id}")
	public Sucursal detalleSucursal(@PathVariable Long id) {
		Sucursal sucursal = sucursalService.findById(id);
		return sucursal;
	}

	// http://localhost:8001/sucursales/add (POST)
	@RequestMapping(value = "/sucursales/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sucursal> agregarSucursal(@RequestBody Sucursal sucursalNew) {
		Sucursal sucursalAdd = sucursalService.addSucursal(sucursalNew);
		if (sucursalAdd != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// http://localhost:8001/sucursales/update (PUT)
	@RequestMapping(value = "/sucursales/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sucursal> actualizarSucursal(@RequestBody Sucursal sucursalUp) {
		Sucursal sucursalUpdate = sucursalService.addSucursal(sucursalUp);
		if (sucursalUpdate != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// http://localhost:8001/sucursales/delete/1 (DELETE)
	@RequestMapping(value = "/sucursales/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String eliminarSucursal(@PathVariable Long id) {
		return sucursalService.deleteSucursal(id);
	}

}
