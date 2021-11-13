package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Abertura  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_abertura")
	private Integer id_abertura;
    
    @Column(name = "descripcion_abertura")
	private String descripcion_abertura;
    @Column(name = "precio_abertura")
	private Integer precio_abertura;
    @Column(name = "alta")
	private boolean alta;
	
	
	public Abertura() {
		super();
	}
	
	
	public Abertura(Integer id_abertura, String descripcion_abertura, Integer precio_abertura, boolean alta) {
		super();
		this.id_abertura = id_abertura;
		this.descripcion_abertura = descripcion_abertura;
		this.precio_abertura = precio_abertura;
	}
	public Integer getId_abertura() {
		return id_abertura;
	}
	public void setId_abertura(Integer id_abertura) {
		this.id_abertura = id_abertura;
	}
	public String getDescripcion_abertura() {
		return descripcion_abertura;
	}
	public void setDescripcion_abertura(String descripcion_abertura) {
		this.descripcion_abertura = descripcion_abertura;
	}
	public Integer getPrecio_abertura() {
		return precio_abertura;
	}
	public void setPrecio_abertura(Integer precio_abertura) {
		this.precio_abertura = precio_abertura;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}
	
	
	
}
