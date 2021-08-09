package com.example.practica2.especie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica2.cultivo.Cultivo;
import com.example.practica2.cultivo.ServicioCultivo;

@RestController
public class ControladorEspecie {
	
	@Autowired
	private ServicioCultivo sevicioCultivo;
	
	//Petición GET para devolver la lista de especies pasando el id de un cultivo en concreto. Las sublistas de plagas estarán vacias para ahorrar memoria
	@RequestMapping(value = "/getEspecies/{id}", method = RequestMethod.GET)
	public List<Especie> especies(@PathVariable long id) {
		Cultivo cultivo = this.sevicioCultivo.getOne(id);
		List<Especie> lista =  cultivo.getEspecie();
		for (Especie e: lista) {
			e.getPlagas().clear();
		}
		return lista;
	}
}
