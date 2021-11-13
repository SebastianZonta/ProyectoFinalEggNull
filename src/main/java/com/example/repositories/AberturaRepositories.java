package com.example.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import com.example.entities.Abertura;


@Repository
public interface AberturaRepositories  extends JpaRepository<Abertura, Integer> {
	

 
@Query("SELECT a FROM Abertura a WHERE a.alta = true")

public List<Abertura> buscarAberturaAlta();

@Query("SELECT a FROM Abertura a WHERE a.alta = false")
public List<Abertura> buscarAberturaBaja();



	
}
