package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Rubro;
import com.example.errores.WebException;
import com.example.repositories.RubroRepositories;

@Service
public class RubroServices {
	@Autowired
	private RubroRepositories repository;
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })
	public Rubro guardar(Integer id_rubro, String descrpcion_tipo, Integer precio_rubro)
	{
		Rubro rubro=new Rubro();
		rubro.setId_rubro(id_rubro);
		rubro.setDescrpcion_tipo(descrpcion_tipo);
		rubro.setPrecio_rubro(precio_rubro);
		repository.save(rubro);
		return rubro;
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })
	public Rubro modificar(Integer id_rubro, String descrpcion_tipo, Integer precio_rubro) throws WebException
	{
		Optional<Rubro> rubro=repository.findById(id_rubro);
		if (rubro.isPresent()) {
			Rubro rubroModi=rubro.get();
			rubroModi.setDescrpcion_tipo(descrpcion_tipo);
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
	@Transactional(readOnly = true)
	public List<Rubro> getAll()
	{
		return repository.findAll();
	}
}
