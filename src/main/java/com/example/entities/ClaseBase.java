package com.example.entities;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public abstract class ClaseBase {
	
	@Id
	private Integer id;
	
	private Boolean esEliminado;

	
	
	public ClaseBase() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEsEliminado() {
		return esEliminado;
	}
	
	public void setEsEliminado(Boolean esEliminado) {
		this.esEliminado = esEliminado;
	}
	
	
}
