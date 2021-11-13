package com.example.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
	private Integer id_usuario;
    @Column(name = "nombre")
	private String nombre;
    @Column(name = "apellido")
	private String apellido;
    @Column(name = "email")
    
	private String email;

	@Column(name = "numero")
    private long numero;
	@Column(name = "password")
	private String password;
	@Column(name = "alta")
	private boolean alta;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro")
	private Date fecha_registro;

	
@OneToOne
@JoinColumn(name = "rol_id")
	private Rol rol;

	

	public Usuario() {
		super();
	}
	
	
	public Usuario(Integer id_usuario, String nombre, String apellido, String password, Date fecha_registro,
			String email, long numero , Rol id_rol, boolean alta ) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.alta = alta;
		this.fecha_registro = fecha_registro;
		this.email = email;
		this.numero = numero;
		this.rol = id_rol;
		
	}
	public boolean isAlta() {
		return alta;
	}


	public void setAlta(boolean alta) {
		this.alta = alta;
	}


	public Rol getId_rol() {
		return rol;
	}


	public void setId_rol(Rol id_rol) {
		this.rol = id_rol;
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
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}

	
	
	
}
