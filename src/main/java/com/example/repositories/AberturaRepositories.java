package com.example.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Abertura;


@Repository
public interface AberturaRepositories extends JpaRepository<Abertura, Integer> {
	
}
