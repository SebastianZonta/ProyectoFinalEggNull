package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Abertura;
import com.example.entities.Tamanio;

import com.example.errores.WebException;
import com.example.repositories.TamanioRepositories;



@Service
public class TamanioServices {
 
	@Autowired
	private TamanioRepositories rpsTamanio;
	
	 @Transactional
	public void tamanio( String descripcion_tamanio, Integer tamanio, Integer tamanio_precio)throws WebException{
		
		/*validar(descripcion_tamanio, tamanio,tamanio_precio); */
		
		Tamanio tam = new Tamanio();
	
	    tam.setDescripcion_tamanio(descripcion_tamanio);
	    tam.setTamanio(tamanio);
	    tam.setPrecio_tamanio(tamanio_precio);
	    rpsTamanio.save(tam);

}
	
	 @Transactional
	public void modificar(Integer id , String descripcion_tamanio, Integer tamanio, Integer tamanio_precio)throws WebException {
		
		validar(descripcion_tamanio, tamanio,tamanio_precio);
		
		Optional<Tamanio> modificar = rpsTamanio.findById(id);
		if(modificar.isPresent()) {
			Tamanio tam = modificar.get();
			  tam.setDescripcion_tamanio(descripcion_tamanio);
			    tam.setTamanio(tamanio);
			    tam.setPrecio_tamanio(tamanio_precio);
			    rpsTamanio.save(tam);
		}
		
	}
	 @Transactional
	public void desahibilitar(Integer id, boolean alta) {
		Optional<Tamanio> modificar = rpsTamanio.findById(id);
		if(modificar.isPresent()) {
		Tamanio tam = modificar.get();
		tam.setAlta(false);
		rpsTamanio.save(tam);
		}
	}
	
	 @Transactional
	public Optional<Tamanio> buscarTamanioPorID(Integer id){
		Optional<Tamanio> buscar = rpsTamanio.findById(id);
		return buscar;
	}
	
	 @Transactional
		public List<Tamanio> buscarTamanio(){
			List<Tamanio> tamanio = rpsTamanio.findAll();	
			return tamanio;
		}

	
	 
	 @Transactional
	    public void precioabertura(Tamanio tamanio){
	    	
	  
	   if(tamanio.getTamanio() == 15){
		   tamanio.setPrecio_tamanio(5000);
	   }
	   
	   if(tamanio.getTamanio() == 10){
		   tamanio.setPrecio_tamanio(1000);
	    
	    }
	    }
	    
	 
	 
	 
	 
	 
	 
	 
	
	private void validar(String descripcion_tamanio, Integer tamanio, Integer tamanio_precio) throws WebException{
		
		if(descripcion_tamanio == null || descripcion_tamanio.isEmpty())  {
			throw new WebException("la descripcion  no puede estar vacio");
		}
		if(tamanio == null) {
			throw new WebException("el tamanio no puede estar vacio");
		}
		
		if(tamanio_precio ==null ) {
			throw new WebException("el precio no puede estar vacio");
		}
				
	}
	
}