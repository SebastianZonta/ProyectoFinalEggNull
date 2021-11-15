package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rubro {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id_rubro")
	private Integer id_rubro;
	@Column(name = "descripcion_tipo")
	private String descrpcion_tipo;
	@Column(name = "precio_rubro")
	private Integer precio_rubro;
	@Column(name = "alta")
	private Boolean alta;
	
	
	public Boolean getEstaEliminado() {
		return alta;
	}

	public void setEstaEliminado(Boolean estaEliminado) {
		this.alta = estaEliminado;
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
