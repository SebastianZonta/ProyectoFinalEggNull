package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Rubro;

@Repository
public interface RubroRepositories extends JpaRepository<Rubro, Integer> {
	
	/*
		@Query("select * from rubro where esEliminado=:esEliminado")
		List<Rubro> getRubrosActivos(@Param("esEliminadio")Boolean esEliminado);
		 */
		
}
