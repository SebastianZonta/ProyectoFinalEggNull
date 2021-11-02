package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Usuario;

public interface  UserRepository extends JpaRepository<Usuario, Integer> {

}
