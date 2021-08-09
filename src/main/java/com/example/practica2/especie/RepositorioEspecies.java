package com.example.practica2.especie;

import org.springframework.data.jpa.repository.JpaRepository;

//Métodos y utilización de la base de datos H2 de JpaRepository
public interface RepositorioEspecies extends JpaRepository<Especie, Long> {
	Especie findByNombre(String nombre);
}