package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Abertura;
import com.example.entities.Disposicion;
import com.example.errores.WebException;
import com.example.repositories.DisposicionRepositories;

@Service
public class DisposicionServices {

@Autowired
private DisposicionRepositories rpsDisposicion;

//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class }

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })

public Disposicion registrar(String descripcion_disposicion ,Integer precio_disposicion) throws WebException{
	
	validar(descripcion_disposicion,precio_disposicion);
	  		
		Disposicion disposicion = new Disposicion();
		disposicion.setDescripcion_disposicion(descripcion_disposicion);
		disposicion.setPrecio_disposicion(precio_disposicion);
		
		rpsDisposicion.save(disposicion);
		return disposicion;
	}

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })

public Disposicion modificar (Integer id,String descripcion_disposicion, Integer precio_disposicion) throws WebException {
	
	validar(descripcion_disposicion,precio_disposicion);
	
	Optional<Disposicion> modificar = rpsDisposicion.findById(id);
	if(modificar.isPresent()) {
		
		Disposicion disposicion = modificar.get();
		disposicion.setDescripcion_disposicion(descripcion_disposicion);
		disposicion.setPrecio_disposicion(precio_disposicion);
	    
	    rpsDisposicion.save(disposicion);
	    return disposicion;
	    
		}else {
			throw new WebException("no se ha encontrado la solicitud");
		}
	
}

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })

public Disposicion desahibilitar (Integer id) throws WebException {
	
	Optional<Disposicion> modificar = rpsDisposicion.findById(id);
	if(modificar.isPresent()) {
	
		Disposicion disposicion = modificar.get();
		disposicion.setAlta(false);
		rpsDisposicion.save(disposicion);
	
		return disposicion;
		}else{
			throw new WebException("no se ha encontrado la solicitud");
		}
		}

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })

public Disposicion alta (Integer id) throws WebException {
	
	Optional<Disposicion> modificar = rpsDisposicion.findById(id);
	if(modificar.isPresent()) {
	
		Disposicion disposicion = modificar.get();
		disposicion.setAlta(true);
		rpsDisposicion.save(disposicion);
	
		return disposicion;
		}else{
			throw new WebException("no se ha encontrado la solicitud");
		}
		}
@Transactional(readOnly = true)

public Optional<Disposicion> buscarDisposicionPorID(Integer id){
	Optional<Disposicion> buscar = rpsDisposicion.findById(id);
	return buscar;
}

@Transactional(readOnly = true)
public List<Disposicion> listarTodos(){
	return rpsDisposicion.findAll();
}

@Transactional
	public List<Disposicion> buscarDisposicion(){
		List<Disposicion> buscar = rpsDisposicion.findAll();
		
		return buscar;
	}


@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })

private void validar(String descripcion_disposicion ,Integer precio_disposicion) throws WebException{
	
	
	if(descripcion_disposicion == null || descripcion_disposicion.isEmpty())  {
		throw new WebException("La descripcion no puede estar vacia");
	}
	if(precio_disposicion == null) {
		throw new WebException("el precio no puede estar vacio");
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
 


}
