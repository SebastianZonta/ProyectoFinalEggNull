package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.errores.WebException;
import com.example.services.UsuarioServices;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private UsuarioServices usuarioServices;
	
	
	@GetMapping("/")
	public String index(ModelMap modelo) {
						
		return "NomelaContainer.html";
	}

	@GetMapping("/panel8")
	public ModelAndView mostrarFormulario() {
		return new ModelAndView("NomelaContainer");
	}
	
	@PostMapping("/crear")
	public String registrar( @RequestParam("nombre") String nombre , 
			@RequestParam("apellido") String apellido , @RequestParam("email") String email , 
			 @RequestParam("password") String password ,
			@RequestParam("password2") String password2) throws WebException{
	 
		try {
		usuarioServices.registrar(nombre, apellido, null, email,password, password2);
		System.out.println("nombre" + nombre);
		System.out.println("apellido" + apellido);
		System.out.println("email" + email);
		System.out.println("password" + password);
		System.out.println("password2" + password2);
		System.out.println("arranco");
		return "redirect:/ ";
	}catch(Exception e){
		System.out.println(e.getMessage());
		System.out.println(e.getStackTrace());
		System.out.println("nombre" + nombre);
		System.out.println("apellido" + apellido);
		System.out.println("email" + email);
		System.out.println("password" + password);
		System.out.println("password2" + password2);
		System.out.println("no arranco");
		return "redirect:/";
	}
	}

	@GetMapping("/panel7")
	public ModelAndView mostrarlogi() {
		return new ModelAndView("NomelaContainer");
	}
	

	@GetMapping("/login")
	public ModelAndView mostrarlogin() {
		return new ModelAndView("login");
	}
	
	
}
