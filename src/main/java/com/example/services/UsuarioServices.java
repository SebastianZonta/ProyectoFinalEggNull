package com.example.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;


import com.example.entities.Usuario;
import com.example.errores.WebException;
import com.example.repositories.UsuarioRepositories;


@Service
public class UsuarioServices implements UserDetailsService {

@Autowired
private UsuarioRepositories rpsUsuario;


	
@Transactional
public Usuario registrar(long numero,String nombre ,String apellido ,Date fecha_registro, String email ,  String password,String password2) throws WebException{
	
  validar(nombre,apellido,email,password,password2);
	
	Usuario usuario = new Usuario();
	usuario.setNombre(nombre);
	usuario.setApellido(apellido);
	usuario.setAlta(true);
	usuario.setFecha_registro(new Date());
	usuario.setNumero(numero);
	usuario.setEmail(email);

	   String ecriptada = new BCryptPasswordEncoder().encode(password);
	  
		usuario.setPassword(ecriptada);
	
	
	rpsUsuario.save(usuario);
	return usuario;
}

@Transactional
public Usuario modificar(Integer id , String nombre ,String apellido, String email ,long numero, String password, String password2) throws WebException{
	
	validar(nombre,apellido,email,password,password2);
	
	Optional<Usuario> modificar = rpsUsuario.findById(id);
	if(modificar.isPresent()) {
	
	Usuario usuario = modificar.get();
	usuario.setNombre(nombre);
	usuario.setApellido(apellido);
	usuario.setEmail(email);
    usuario.setNombre(nombre);
    
   String ecriptada = new BCryptPasswordEncoder().encode(password);
  
	usuario.setPassword(ecriptada);
    
    
    rpsUsuario.save(usuario);
    return usuario;
    
	}else {
		throw new WebException("no se ha encontrado la solicitud");
	}
	
	}
 
@Transactional
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

@Transactional
public Optional<Usuario> buscarUsuarioPorID(Integer id){
	Optional<Usuario> buscar = rpsUsuario.findById(id);
	return buscar;
}

@Transactional(readOnly = true)
public List<Usuario> getAll()
{
	return rpsUsuario.findAll();
}

private void validar(String nombre ,String apellido, String email ,String password , String password2) throws WebException{
	
	
	if(nombre == null || nombre.isEmpty())  {
		throw new WebException("el nombre no puede estar vacio");
	}
	if(apellido == null || apellido.isEmpty()) {
		throw new WebException("el apellido no puede estar vacio");
	}
	
	/*if(numero ==null ) {
		throw new WebException("el numereo no puede estar vacio");
	} */
	if(email == null || email.isEmpty()) {
		throw new WebException("el email no puede estar vacio");
	}

	if(password == null || password.isEmpty()) {
		throw new WebException("el nombre no puede estar vacio");
	}
	if(!password2.equals(password)) {
		throw new WebException("la contraseña no coincide");
	}
	
}

@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	Usuario usuario = (Usuario) rpsUsuario.buscarporemail(email);
	
	if(usuario !=null) {
		
		List<GrantedAuthority> permiso = new ArrayList<>();
		GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_USUARIO_REGISTRADO");
		GrantedAuthority p2 = new SimpleGrantedAuthority("ROLE_ADMIN_REGISTRADO");
		
		permiso.add(p1);
		permiso.add(p2);

		User user = new User(usuario.getEmail(), usuario.getPassword() , permiso);
		return user;
	}else {
		return null;
	}
	
}

}

