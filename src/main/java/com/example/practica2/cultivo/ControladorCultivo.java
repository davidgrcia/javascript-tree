package com.example.practica2.cultivo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControladorCultivo {

	@Autowired
	private ServicioCultivo sevicioCultivo;
	
	//Petición GET para devolver la lista de cultivos inicial con sus respectivas listas de especies vacias, para ahorrar memoria
	@RequestMapping(value = "/getCultivos", method = RequestMethod.GET)
	public List<Cultivo> cultivos() {
		List<Cultivo> lista = this.sevicioCultivo.findAll();
		for (Cultivo c: lista) {
			c.getEspecie().clear();
		}
		return lista;
	}
}
