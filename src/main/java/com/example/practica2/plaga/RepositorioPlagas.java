package com.example.practica2.plaga;

import org.springframework.data.jpa.repository.JpaRepository;

//Métodos y utilización de la base de datos H2 de JpaRepository
public interface RepositorioPlagas extends JpaRepository<Plaga, Long> {
	Plaga findByNombre(String nombre);
}