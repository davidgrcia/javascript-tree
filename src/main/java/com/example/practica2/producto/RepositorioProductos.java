package com.example.practica2.producto;

import org.springframework.data.jpa.repository.JpaRepository;

//Métodos y utilización de la base de datos H2 de JpaRepository
public interface RepositorioProductos extends JpaRepository<Producto, Long> {
	Producto findByNombre(String nombre);
}