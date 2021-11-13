package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tamanio {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tamanio")
	private Integer id_tamanio;
    
    @Column(name = "alta")
	private boolean alta;
    @Column(name = "tamanio")
	private String tamanio;
    @Column(name = "precio_tamanio")
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

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public Tamanio(Integer id_tamanio, Integer precio_tamanio , String tamanio, boolean alta ) {
		super();
		this.id_tamanio = id_tamanio;
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
	
	public Integer getPrecio_tamanio() {
		return precio_tamanio;
	}
	public void setPrecio_tamanio(Integer precio_tamanio) {
		this.precio_tamanio = precio_tamanio;
	}
	
	
	
	
}
