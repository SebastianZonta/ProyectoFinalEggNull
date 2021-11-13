package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Usuario;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Integer>{

	
	@Query("SELECT a FROM Usuario a where a.email =:email")
	public Usuario  buscarporemail(@Param("email") String  email);

	
	
}
