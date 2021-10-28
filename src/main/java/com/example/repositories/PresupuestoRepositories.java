package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Presupuesto;

@Repository
public interface PresupuestoRepositories extends JpaRepository<Presupuesto, Integer> {

}
