package com.example.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entities.Usuario;
import com.example.errores.WebException;
import com.example.repositories.UsuarioRepositories;


@Service
public class UsuarioServices {

@Autowired
private UsuarioRepositories rpsUsuario;
	
public Usuario registrar(String nombre ,String apellido ,Date fecha_registro, String email , Integer numero , String password) throws WebException{
	
  validar(nombre,apellido,email,numero,password);
	
	Usuario usuario = new Usuario();
	usuario.setNombre(nombre);
	usuario.setApellido(apellido);
	usuario.setAlta(true);
	usuario.setFecha_registro(new Date());
	usuario.setNumero(numero);
	usuario.setEmail(email);
	usuario.setPassword(password);
	
	rpsUsuario.save(usuario);
	return usuario;
}

public Usuario modificar(Integer id , String nombre ,String apellido, String email ,Integer numero, String password) throws WebException{
	
	validar(nombre,apellido,email,numero,password);
	
	Optional<Usuario> modificar = rpsUsuario.findById(id);
	if(modificar.isPresent()) {
	
	Usuario usuario = modificar.get();
	usuario.setNombre(nombre);
	usuario.setApellido(apellido);
	usuario.setEmail(email);
    usuario.setNombre(nombre);
    usuario.setPassword(password);
    
    rpsUsuario.save(usuario);
    return usuario;
    
	}else {
		throw new WebException("no se ha encontrado la solicitud");
	}
	
	}
 
public Usuario desahibilitar(Integer id, boolean alta) throws WebException {
	Optional<Usuario> modificar = rpsUsuario.findById(id);
	if(modificar.isPresent()) {
	Usuario usuario = modificar.get();
	usuario.setAlta(false);
	rpsUsuario.save(usuario);
	 return usuario;
}else{
	throw new WebException("no se ha encontrado la solicitud");

}
}

public Optional<Usuario> buscarUsuarioPorID(Integer id){
	Optional<Usuario> buscar = rpsUsuario.findById(id);
	return buscar;
}

private void validar(String nombre ,String apellido, String email , Integer numero , String password) throws WebException{
	
	
	if(nombre == null || nombre.isEmpty())  {
		throw new WebException("el nombre no puede estar vacio");
	}
	if(apellido == null || apellido.isEmpty()) {
		throw new WebException("el apellido no puede estar vacio");
	}
	
	if(numero ==null ) {
		throw new WebException("el numereo no puede estar vacio");
	}
	if(email == null || email.isEmpty()) {
		throw new WebException("el email no puede estar vacio");
	}

	if(password == null || password.isEmpty()) {
		throw new WebException("el nombre no puede estar vacio");
	}
	
}

}
