package com.example.practica2.sustancia;

import org.springframework.data.jpa.repository.JpaRepository;

//Métodos y utilización de la base de datos H2 de JpaRepository
public interface RepositorioSustancias extends JpaRepository<Sustancia, Long> {
	Sustancia findByNombre(String nombre);
}