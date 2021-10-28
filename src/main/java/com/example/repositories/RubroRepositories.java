package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Rubro;

@Repository
public interface RubroRepositories extends JpaRepository<Rubro, Integer> {

}
