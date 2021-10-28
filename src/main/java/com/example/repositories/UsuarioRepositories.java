package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Usuario;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Integer>{

}
