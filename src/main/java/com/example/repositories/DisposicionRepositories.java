package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Disposicion;


@Repository
public interface DisposicionRepositories extends JpaRepository<Disposicion, Integer>{
	
	/*
	@Query("SELECT a from Perro a WHERE a.activo = true ")
	public List<Disposicion> buscarActivos();	*/
	
}

