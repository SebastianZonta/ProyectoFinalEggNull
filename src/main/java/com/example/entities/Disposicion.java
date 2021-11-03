package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Disposicion  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_disposicion;
	
	private String descripcion_disposicion;
	private Integer precio_disposicion;
	private Boolean alta;
	
	public Disposicion() {
		
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

	public Integer getPrecio_disposicion() {
		return precio_disposicion;
	}

	public void setPrecio_disposicion(Integer precio_disposicion) {
		this.precio_disposicion = precio_disposicion;
	}

	public Boolean getAlta() {
		return alta;
	}

	public void setAlta(Boolean alta) {
		this.alta = alta;
	}
		
	
	
}
