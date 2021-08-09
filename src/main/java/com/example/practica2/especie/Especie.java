package com.example.practica2.especie;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.example.practica2.plaga.Plaga;

@Entity
public class Especie {
	
	// Clave primaria de la base de datos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	
	// Atributos y lista con relación many to many
	private String nombre;
	private String nombreCientifico;
	@ManyToMany
	@JoinColumn(name="Plagas", nullable=false)
	private List<Plaga> plagas;

	// CONSTRUCTORES 
	public Especie() {}


	public Especie(String nombre, String nombreCientifico, List<Plaga> plagas) {
		super();
		this.nombre = nombre;
		this.nombreCientifico = nombreCientifico;
		this.plagas = plagas;
	}

	public Especie(String nombre, String nombreCientifico) {
		super();
		this.nombre = nombre;
		this.nombreCientifico = nombreCientifico;
		this.plagas = new ArrayList<>();
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


	public String getNombreCientifico() {
		return nombreCientifico;
	}


	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}


	public List<Plaga> getPlagas() {
		return plagas;
	}


	public void setPlagas(List<Plaga> plagas) {
		this.plagas = plagas;
	}
}
