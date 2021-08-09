package com.example.practica2.sustancia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.example.practica2.producto.Producto;

@Entity
public class Sustancia {
	
	// Clave primaria de la base de datos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	
	// Atributos y lista con relación many to many
	private String nombre;
	
	@ManyToMany
	@JoinColumn(name="Productos", nullable=false)
	private List<Producto> productos;
	
	// CONSTRUCTORES 
	public Sustancia() {}

	public Sustancia(String nombre, List<Producto> productos) {
		super();
		this.nombre = nombre;
		this.productos = productos;
	}

	public Sustancia(String nombre) {
		super();
		this.nombre = nombre;
		this.productos = new ArrayList<>();
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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
