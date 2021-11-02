package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Abertura;
import com.example.entities.ClaseBase;

@Repository
public interface AberturaRepositories extends JpaRepository<Abertura, Integer> {
	
}
