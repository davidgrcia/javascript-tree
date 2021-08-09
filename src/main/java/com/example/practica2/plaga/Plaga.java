package com.example.practica2.plaga;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.example.practica2.sustancia.Sustancia;

@Entity
public class Plaga {
		
	// Clave primaria de la base de datos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	
	// Atributos y lista con relación many to many
	private String nombre;
	private String nombreCientifico;
	private String url;
	@ManyToMany
	@JoinColumn(name="Sustancias", nullable=false)
	private List<Sustancia> sustancias;
	
	// CONSTRUCTORES 
	public Plaga() {}

	public Plaga(String nombre, String nombreCientifico, String url, List<Sustancia> sustancias) {
		super();
		this.nombre = nombre;
		this.nombreCientifico = nombreCientifico;
		this.url = url;
		this.sustancias = sustancias;
	}
	
	public Plaga(String nombre, String nombreCientifico, String url) {
		super();
		this.nombre = nombre;
		this.nombreCientifico = nombreCientifico;
		this.url = url;
		this.sustancias = new ArrayList<>();
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

	public List<Sustancia> getSustancias() {
		return sustancias;
	}

	public void setSustancias(List<Sustancia> sustancias) {
		this.sustancias = sustancias;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
