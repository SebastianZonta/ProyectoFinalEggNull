package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.ClaseBase;
import com.example.entities.Usuario;

public interface  UserRepository<TClass extends ClaseBase,TID> extends BaseRepository<TClass, TID> {

}
