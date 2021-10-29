package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.ClaseBase;

public interface BaseRepository<TClass extends ClaseBase,TID> extends JpaRepository<TClass, TID>{
	public String nombreTabla="tabla";
	
	@Query("SELECT tabla from :tabla tabla where tabla.esEliminado=0")
	public List<TClass> listarEntidadesActivos(@Param("tabla") String tabla);
}
