package com.example.practica2.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica2.sustancia.ServicioSustancias;
import com.example.practica2.sustancia.Sustancia;

@RestController
public class ControladorProducto {
	
	@Autowired
	private ServicioSustancias servicioSustancia;
	
	//Petición GET para devolver la lista de productos pasando el id de una sustancia en concreto.
	@RequestMapping(value = "/getProductos/{id}", method = RequestMethod.GET)
	public List<Producto> productos(@PathVariable long id) {
		Sustancia sustancia = this.servicioSustancia.getOne(id);
		
		return sustancia.getProductos();
	}
	
}
