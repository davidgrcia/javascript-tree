package com.example.practica2.plaga;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.practica2.especie.Especie;
import com.example.practica2.especie.ServicioEspecie;

@RestController
public class ControladorPlaga {
	
	@Autowired
	private ServicioEspecie servicioEspecie;
	
	//Petición GET para devolver la lista de plagas pasando el id de una especie en concreto. Las sublistas de sustancias estarán vacias para ahorrar memoria
	@RequestMapping(value = "/getPlagas/{id}", method = RequestMethod.GET)
	public List<Plaga> plagas(@PathVariable long id) {
		Especie especie = this.servicioEspecie.getOne(id);

		List<Plaga> lista =  especie.getPlagas();
		for (Plaga p: lista) {
			p.getSustancias().clear();
		}
		return lista;
	}
	
}
