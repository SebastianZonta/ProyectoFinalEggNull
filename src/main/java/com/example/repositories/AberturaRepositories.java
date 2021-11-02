package com.example.repositories;

import org.springframework.stereotype.Repository;

import com.example.entities.ClaseBase;

@Repository
public interface AberturaRepositories<TClass extends ClaseBase,TID> extends BaseRepository<ClaseBase, TID> {
	
}
