package com.example.practica2.cultivo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.example.practica2.especie.Especie;


@Entity
public class Cultivo {

	// Clave primaria de la base de datos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	
	// Atributos y lista con relación many to many
	private String nombre;
	@ManyToMany
	@JoinColumn(name="Especie", nullable=false)
	private List<Especie> especie;
	
	// CONSTRUCTORES 
	public Cultivo(){}
	
	public Cultivo(String nombre, List<Especie> especie) {
		super();
		this.nombre = nombre;
		this.especie = especie;
	}
	
	public Cultivo(String nombre) {
		super();
		this.nombre = nombre;
		this.especie = new ArrayList<>();
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

	public List<Especie> getEspecie() {
		return especie;
	}

	public void setEspecie(List<Especie> especie) {
		this.especie = especie;
	}
}
