package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entities.Foto;
import com.example.errores.WebException;
import com.example.repositories.FotoRepositories;

@Service
public class FotoServices {

	@Autowired
	private FotoRepositories rpsFoto;
	
	
	public Foto guardar(MultipartFile archivo) throws WebException  {
		if(archivo != null) {
			try {
				Foto foto = new Foto();
				foto.setMime(archivo.getContentType());
				foto.setNombre(archivo.getName());
				foto.setContenido(archivo.getBytes());
				return rpsFoto.save(foto);
			}catch(Exception e) {
				
			}
		}
		 
		return null;
	}
	
	
	public Foto actualizar(String id , MultipartFile archivo)throws WebException{
		if(archivo != null) {
			try {
				
				Foto foto = new Foto();
				
				if(foto != null) {
					Optional<Foto> buscar = rpsFoto.findById(id);
					if(buscar.isPresent()) {
						buscar.get();
					}
				}
				
				foto.setMime(archivo.getContentType());
				foto.setNombre(archivo.getName());
				foto.setContenido(archivo.getBytes());
				return rpsFoto.save(foto);
			}catch(Exception e) {
				
			}
		}
		 
		return null;
	}
	
	
}
