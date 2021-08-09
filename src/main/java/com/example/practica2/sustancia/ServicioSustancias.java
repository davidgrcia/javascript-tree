package com.example.practica2.sustancia;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//Servicio de sustancia con los metodos necesarios para manipular el repositorio
@Service
public class ServicioSustancias {

	private RepositorioSustancias repository;

	public ServicioSustancias(RepositorioSustancias repository){
		this.repository = repository;
	}

	public Optional<Sustancia> findOne(long id) {
		return repository.findById(id);
	}
	
	public Sustancia getOne(long id) {
		return repository.getOne(id);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<Sustancia> findAll() {
		return repository.findAll();
	}

	public Sustancia save(Sustancia p) {
		Sustancia nuevoProducto = repository.save(p);
		return nuevoProducto;
	}
}
