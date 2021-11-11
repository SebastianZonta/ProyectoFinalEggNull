package com.example.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Abertura;
import com.example.entities.Usuario;
import com.example.errores.WebException;
import com.example.repositories.AberturaRepositories;



@Service
public class AberturaServices {

	@Autowired
	private AberturaRepositories aberturaRepositories;
	
    @Transactional
	public Abertura guardar(Integer id_abertura,String descripcion_abertura, Integer precio_abertura) throws WebException {
	
    	validar( id_abertura,descripcion_abertura,precio_abertura);
    	
    	Abertura entidad = new Abertura();
	
	 entidad.setId_abertura(id_abertura);
	 entidad.setDescripcion_abertura(descripcion_abertura);
	 entidad.setPrecio_abertura(precio_abertura);
	 entidad.setAlta(true);
	 
	 aberturaRepositories.save(entidad);
	 return entidad;
}
    @Transactional
    public Abertura modificar(Integer id_abertura,String descripcion_abertura, Integer precio_abertura) throws WebException {
    
    	validar( id_abertura,descripcion_abertura,precio_abertura);
    	
    	Optional<Abertura> modificar = aberturaRepositories.findById(id_abertura); 
    	if(modificar.isPresent()) {
    	
    	Abertura entidad = modificar.get();
    	
        entidad.setDescripcion_abertura(descripcion_abertura);
    	entidad.setPrecio_abertura(precio_abertura);
    	
        aberturaRepositories.save(entidad);
    	return entidad;
    	}else{
    		throw new WebException(" no se ha encontrado la solcitud");
    	}
    	}
    
    @Transactional
    public Abertura DarBaja(Integer id_abertura) throws WebException {
    	
    	Optional<Abertura> modificar = aberturaRepositories.findById(id_abertura); 
    	if(modificar.isPresent()) {
    	
    	Abertura entidad = modificar.get();
        entidad.setAlta(false);
    	
        aberturaRepositories.save(entidad);
    	return entidad;
    	
    	}else{
    		throw new WebException(" no se ha encontrado la solcitud");
    	}
    	}
    
    @Transactional
    public Abertura DarAlta(Integer id_abertura) throws WebException {
    	
    	Optional<Abertura> modificar = aberturaRepositories.findById(id_abertura); 
    	if(modificar.isPresent()) {
    	
    	Abertura entidad = modificar.get();
        entidad.setAlta(true);
    	
        aberturaRepositories.save(entidad);
    	return entidad;
    	
    	}else{
    		throw new WebException(" no se ha encontrado la solcitud");
    	}
    	}
    
    
    @Transactional
    public void precioabertura(Abertura abertura){
    	
  
   if(abertura.getDescripcion_abertura().equals("aluminio")){
	   abertura.setPrecio_abertura(15000);
   }
   
   if(abertura.getDescripcion_abertura().equals("madera")){
	   abertura.setPrecio_abertura(10000);
    
    }
    }
    
    @Transactional
   	public List<Abertura> buscarAbertura(){
   		List<Abertura> abertura = aberturaRepositories.findAll();
   		
   		return abertura;
   	}

    
    
    
    
    @Transactional(readOnly = true)
    public List<Abertura> getAll()
    {
    	return  aberturaRepositories.findAll();
    }
    
    
    @Transactional(readOnly=true)
    public Optional<Abertura> buscarAberturaPorID(Integer id_abertura){
    	Optional<Abertura> buscar = aberturaRepositories.findById(id_abertura);
    	return buscar;
    }
    
    @Transactional
    private void validar(Integer id_abertura,String descripcion_abertura, Integer precio_abertura) throws WebException{
    	
    	
    	if(id_abertura == null )  {
    		throw new WebException("el nombre no puede estar vacio");
    	}
    	if(descripcion_abertura == null || descripcion_abertura.isEmpty()) {
    		throw new WebException("el apellido no puede estar vacio");
    	}
    	
    	if(precio_abertura == null ) {
    		throw new WebException("el numereo no puede estar vacio");
    	}
    	
    }
    
    
    
    
    
    
    
}