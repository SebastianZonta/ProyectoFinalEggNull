package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Disposicion  {
	@Id
    private Integer id_disposicion;
	
	private String descripcion_disposicion;
	private Integer precio_abertura;
	
	public Disposicion() {
		super();
	}
	
	
	public Disposicion(Integer id_disposicion, String descripcion_disposicion, Integer precio_abertura) {
		super();
		this.id_disposicion = id_disposicion;
		this.descripcion_disposicion = descripcion_disposicion;
		this.precio_abertura = precio_abertura;
	}
	public Integer getId_disposicion() {
		return id_disposicion;
	}
	public void setId_disposicion(Integer id_disposicion) {
		this.id_disposicion = id_disposicion;
	}
	public String getDescripcion_disposicion() {
		return descripcion_disposicion;
	}
	public void setDescripcion_disposicion(String descripcion_disposicion) {
		this.descripcion_disposicion = descripcion_disposicion;
	}
	public Integer getPrecio_abertura() {
		return precio_abertura;
	}
	public void setPrecio_abertura(Integer precio_abertura) {
		this.precio_abertura = precio_abertura;
	}
	
	
}
