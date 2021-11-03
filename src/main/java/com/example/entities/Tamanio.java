package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tamanio {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tamanio;
    
	private String descripcion_tamanio;
	private boolean alta;
	private Integer tamanio;
	private Integer precio_tamanio;
	
	public Tamanio() {
		super();
	}
	
	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	public Integer getTamanio() {
		return tamanio;
	}

	public void setTamanio(Integer tamanio) {
		this.tamanio = tamanio;
	}

	public Tamanio(Integer id_tamanio, String descripcion_tamanio, Integer precio_tamanio , Integer tamanio, boolean alta ) {
		super();
		this.id_tamanio = id_tamanio;
		this.descripcion_tamanio = descripcion_tamanio;
		this.precio_tamanio = precio_tamanio;
		this.tamanio = tamanio;
		this.alta = alta;
	}
	public Integer getId_tamanio() {
		return id_tamanio;
	}
	public void setId_tamanio(Integer id_tamanio) {
		this.id_tamanio = id_tamanio;
	}
	public String getDescripcion_tamanio() {
		return descripcion_tamanio;
	}
	public void setDescripcion_tamanio(String descripcion_tamanio) {
		this.descripcion_tamanio = descripcion_tamanio;
	}
	public Integer getPrecio_tamanio() {
		return precio_tamanio;
	}
	public void setPrecio_tamanio(Integer precio_tamanio) {
		this.precio_tamanio = precio_tamanio;
	}
	
	
	
	
}
