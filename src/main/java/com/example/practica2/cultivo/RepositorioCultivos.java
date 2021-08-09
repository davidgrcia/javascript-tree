package com.example.practica2.cultivo;

import org.springframework.data.jpa.repository.JpaRepository;

//Métodos y utilización de la base de datos H2 de JpaRepository
public interface RepositorioCultivos extends JpaRepository<Cultivo, Long> {
	Cultivo findByNombre(String nombre);
}