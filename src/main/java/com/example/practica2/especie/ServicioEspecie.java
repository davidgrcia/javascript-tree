package com.example.practica2.especie;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//Servicio de especie con los metodos necesarios para manipular el repositorio
@Service
public class ServicioEspecie {

	private RepositorioEspecies repository;

	public ServicioEspecie(RepositorioEspecies repository){
		this.repository = repository;
	}

	public Optional<Especie> findOne(long id) {
		return repository.findById(id);
	}
	
	public Especie getOne(long id) {
		return repository.getOne(id);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<Especie> findAll() {
		return repository.findAll();
	}

	public Especie save(Especie p) {
		Especie nuevoProducto = repository.save(p);
		return nuevoProducto;
	}
}
