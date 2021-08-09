package com.example.practica2.sustancia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica2.plaga.Plaga;
import com.example.practica2.plaga.ServicioPlaga;

@RestController
public class ControladorSustancia {
	
	@Autowired
	private ServicioPlaga servicioPlaga;
	
	//Petición GET para devolver la lista de sustancias pasando el id de una plaga en concreto. Las sublistas de productos estarán vacias para ahorrar memoria
	@RequestMapping(value = "/getSustancias/{id}", method = RequestMethod.GET)
	public List<Sustancia> productos(@PathVariable long id) {
		Plaga plaga = this.servicioPlaga.getOne(id);
		
		List<Sustancia> lista =  plaga.getSustancias();
		for (Sustancia s: lista) {
			s.getProductos().clear();
		}
		return lista;
	}
	
}
