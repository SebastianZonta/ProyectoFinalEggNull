package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.ClaseBase;
import com.example.errores.WebException;


public abstract class BaseService<TClass extends ClaseBase,TID,TRepository extends JpaRepository<TClass, TID>>  {
	
	@Autowired
	private TRepository repository;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })
	public  TClass guardar(TID id)
	{
	   TClass clase=repository.getById(id);
	   clase.setEsEliminado(false);
	   return clase;
	   
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })
	public TClass baja(TID id)
	{
		TClass clase= repository.getById(id);
		clase.setEsEliminado(true);
		return repository.save(clase);
	}
	@Transactional(readOnly = true)
	public List<TClass> listarTodos()
	{
		return repository.findAll();
	}
	
	
}
