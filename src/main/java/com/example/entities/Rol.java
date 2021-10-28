package com.example.entities;

public class Rol extends ClaseBase{
    
	private Integer id_rol;
	private String descripcion;
	
	
	public Rol(){
		super();
	}
	
	public Rol(Integer id_rol, String descripcion) {
		super();
		this.id_rol = id_rol;
		this.descripcion = descripcion;
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
