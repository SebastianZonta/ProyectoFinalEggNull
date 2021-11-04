package com.example.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {
    @Id
    
	private Integer id_usuario;
	
	private String nombre;
	private String apellido;
	private String email;
	private Integer numero;
	private String password;
	private boolean alta;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_registro;

@OneToOne
	private Rol id_rol;
	
@OneToOne
    private Foto foto;
	
	
	
	
	public Foto getFoto() {
	return foto;
}


public void setFoto(Foto foto) {
	this.foto = foto;
}


	public Usuario() {
		super();
	}
	
	
	public Usuario(Integer id_usuario, String nombre, String apellido, String password, Date fecha_registro,
			String email, Integer numero , Rol id_rol, boolean alta , Foto foto) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.alta = alta;
		this.fecha_registro = fecha_registro;
		this.email = email;
		this.numero = numero;
		this.id_rol = id_rol;
		this.foto = foto;
	}
	public boolean isAlta() {
		return alta;
	}


	public void setAlta(boolean alta) {
		this.alta = alta;
	}


	public Rol getId_rol() {
		return id_rol;
	}


	public void setId_rol(Rol id_rol) {
		this.id_rol = id_rol;
	}


	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	
	
	
}
