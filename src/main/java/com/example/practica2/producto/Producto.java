package com.example.practica2.producto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
	
	// Clave primaria de la base de datos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	
	// Atributos
	private String nombre;
	private String url;

	// CONSTRUCTORES 
	public Producto() {}


	public Producto(String nombre, String url) {
		super();
		this.nombre = nombre;
		this.url = url;
	}

	// GETTERS y SETTERS 
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
}
