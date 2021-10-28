package com.example.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Presupuesto {
@Id
private Integer id_presupuesto;

@OneToOne
private Rubro id_rubro;
@OneToOne
private Tamanio id_tamanio;
@OneToOne
private Disposicion id_disposicion;
@OneToOne
private  Abertura id_abertura;
@OneToOne
private Usuario id_usuario;

private boolean alta;

@Temporal(TemporalType.DATE)
private Date fecha_caducidad;




public Presupuesto() {
	super();
}





public Presupuesto(Integer id_presupuesto, Rubro id_rubro, Tamanio id_tamanio, Disposicion id_disposicion,
		Abertura id_abertura, Usuario id_usuario, boolean alta, Date fecha_caducidad) {
	super();
	this.id_presupuesto = id_presupuesto;
	this.id_rubro = id_rubro;
	this.id_tamanio = id_tamanio;
	this.id_disposicion = id_disposicion;
	this.id_abertura = id_abertura;
	this.id_usuario = id_usuario;
	this.alta = alta;
	this.fecha_caducidad = fecha_caducidad;
}
public Integer getId_presupuesto() {
	return id_presupuesto;
}
public void setId_presupuesto(Integer id_presupuesto) {
	this.id_presupuesto = id_presupuesto;
}
public Rubro getId_rubro() {
	return id_rubro;
}
public void setId_rubro(Rubro id_rubro) {
	this.id_rubro = id_rubro;
}
public Tamanio getId_tamanio() {
	return id_tamanio;
}
public void setId_tamanio(Tamanio id_tamanio) {
	this.id_tamanio = id_tamanio;
}
public Disposicion getId_disposicion() {
	return id_disposicion;
}
public void setId_disposicion(Disposicion id_disposicion) {
	this.id_disposicion = id_disposicion;
}
public Abertura getId_abertura() {
	return id_abertura;
}
public void setId_abertura(Abertura id_abertura) {
	this.id_abertura = id_abertura;
}
public Usuario getId_usuario() {
	return id_usuario;
}
public void setId_usuario(Usuario id_usuario) {
	this.id_usuario = id_usuario;
}


public boolean isAlta() {
	return alta;
}



public void setAlta(boolean alta) {
	this.alta = alta;
}



public Date getFecha_caducidad() {
	return fecha_caducidad;
}



public void setFecha_caducidad(Date fecha_caducidad) {
	this.fecha_caducidad = fecha_caducidad;
}




}
