package com.example.practica2.plaga;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//Servicio de plaga con los metodos necesarios para manipular el repositorio
@Service
public class ServicioPlaga {

	private RepositorioPlagas repository;

	public ServicioPlaga(RepositorioPlagas repository){
		this.repository = repository;
	}

	public Optional<Plaga> findOne(long id) {
		return repository.findById(id);
	}
	
	public Plaga getOne(long id) {
		return repository.getOne(id);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<Plaga> findAll() {
		return repository.findAll();
	}

	public Plaga save(Plaga p) {
		Plaga nuevoProducto = repository.save(p);
		return nuevoProducto;
	}
}
