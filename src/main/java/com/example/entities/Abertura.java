package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Abertura {
    @Id
	private Integer id_abertura;
    
	private String descripcion_abertura;
	private Integer precio_abertura;
	
	
	public Abertura() {
		super();
	}
	
	
	public Abertura(Integer id_abertura, String descripcion_abertura, Integer precio_abertura) {
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
	
	
	
}
