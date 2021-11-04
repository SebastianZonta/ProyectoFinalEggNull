package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Foto;

@Repository
public interface FotoRepositories extends JpaRepository<Foto, String> {

}
