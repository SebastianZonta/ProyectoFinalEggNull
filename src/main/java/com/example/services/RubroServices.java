package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Abertura;
import com.example.entities.Rubro;
import com.example.errores.WebException;
import com.example.repositories.RubroRepositories;

@Service
public class RubroServices {
	@Autowired
	private RubroRepositories repository;
	
	

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class } )
	public Rubro guardar(String descripcion_tipo, Integer precio_rubro)throws WebException

	{
		Validar(descripcion_tipo, precio_rubro);
		
		Rubro rubro=new Rubro();

		rubro.setDescrpcion_tipo(descripcion_tipo);
		
		rubro.setPrecio_rubro(precio_rubro);
		repository.save(rubro);
		return rubro;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })
	public Rubro modificar(Integer id_rubro, String descripcion_tipo, Integer precio_rubro) throws WebException
	{
		Validar(descripcion_tipo, precio_rubro);
		Optional<Rubro> rubro=repository.findById(id_rubro);
		if (rubro.isPresent()) {
			Rubro rubroModi=rubro.get();
			rubroModi.setDescrpcion_tipo(descripcion_tipo);
			rubroModi.setPrecio_rubro(precio_rubro);
			repository.save(rubroModi);
			return rubroModi;
		}
		else {
			throw new WebException("Error");
			}
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })
	public Rubro deshabilitar(Integer id_rubro, Boolean esEliminado) throws WebException
	{
		Optional<Rubro> entidad=repository.findById(id_rubro);
		if (entidad.isPresent()) {
			Rubro rubro=entidad.get();
			rubro.setEstaEliminado(esEliminado);
			repository.save(rubro);
			return rubro;
		}
		else {
			throw new WebException("Error");
		}
		
		
	}
	   @Transactional(readOnly=true)
	    public Optional<Rubro> buscarRubroPorID(Integer id_rubro){
	    	Optional<Rubro> buscar = repository.findById(id_rubro);
	    	return buscar;
	    }
	
	
	
	@Transactional(readOnly = true)
	public List<Rubro> getAll()
	{
		return repository.findAll();
	}
	private void Validar(String descripcion_tipo, Integer precio_rubro) throws WebException
	{
		if (descripcion_tipo.length()==0 || descripcion_tipo.isEmpty()) {
			throw new WebException("Descripcion no puede ser vacia");
		}
		if (precio_rubro==0 || precio_rubro==null) {
			throw new WebException("Descripcion no puede ser vacia");
		}
	}
	
	
	@Transactional
	public void precio(Rubro rubro) {
		
	if(rubro.getDescrpcion_tipo().equals("comercial")) {
		rubro.setPrecio_rubro(20000);
	}
	
	if(rubro.getDescrpcion_tipo().equals("vivienda")) {
		rubro.setPrecio_rubro(35000);
	}
	}
	
	 @Transactional
	   	public List<Rubro> buscarRubro(){
	   		List<Rubro> rubro = repository.findAll();
	   		
	   		return rubro;
	   	}
	
	
}
