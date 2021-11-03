package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rubro {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id_rubro;
	
	private String descrpcion_tipo;
	
	private Integer precio_rubro;
	private Boolean estaEliminado;
	
	
	public Boolean getEstaEliminado() {
		return estaEliminado;
	}

	public void setEstaEliminado(Boolean estaEliminado) {
		this.estaEliminado = estaEliminado;
	}

	public Rubro() {
		super();
	}
	
	public Rubro(Integer id_rubro, String descrpcion_tipo, Integer precio_rubro) {
		super();
		this.id_rubro = id_rubro;
		this.descrpcion_tipo = descrpcion_tipo;
		this.precio_rubro = precio_rubro;
	}
	public Integer getId_rubro() {
		return id_rubro;
	}
	public void setId_rubro(Integer id_rubro) {
		this.id_rubro = id_rubro;
	}
	public String getDescrpcion_tipo() {
		return descrpcion_tipo;
	}
	public void setDescrpcion_tipo(String descrpcion_tipo) {
		this.descrpcion_tipo = descrpcion_tipo;
	}
	public Integer getPrecio_rubro() {
		return precio_rubro;
	}
	public void setPrecio_rubro(Integer precio_rubro) {
		this.precio_rubro = precio_rubro;
	}
	
	
	
}
