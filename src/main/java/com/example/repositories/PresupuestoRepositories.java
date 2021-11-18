package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Presupuesto;

@Repository
public interface PresupuestoRepositories extends JpaRepository<Presupuesto, Integer> {

@Query("SELECT a FROM Presupuesto a Where a.id_usuario =:id")
public List<Presupuesto> listaPresupuesto(@Param ("id") Integer id);
	
}
