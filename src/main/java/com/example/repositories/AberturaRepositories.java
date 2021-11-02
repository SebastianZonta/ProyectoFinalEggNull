package com.example.repositories;

<<<<<<< HEAD
import org.springframework.stereotype.Repository;

=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Abertura;
>>>>>>> parent of 512d722 (arrancar de nuevo)
import com.example.entities.ClaseBase;

@Repository
public interface AberturaRepositories<TClass extends ClaseBase,TID> extends BaseRepository<ClaseBase, TID> {
	
=======
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Abertura;

public interface AberturaRepositories  extends JpaRepository<Abertura, Integer> {

>>>>>>> ramaeze
}
