package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Tamanio;

@Repository
public interface TamanioRepositories extends JpaRepository<Tamanio, Integer>{

}
