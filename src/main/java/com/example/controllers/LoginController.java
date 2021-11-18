package com.example.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Usuario;
import com.example.errores.WebException;
import com.example.services.PresupuestoService;
import com.example.services.UsuarioServices;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private UsuarioServices usuarioServices;
	
	@Autowired
	private PresupuestoService presu;
	
	
	@GetMapping("/")
	public String index(ModelMap modelo) {
						
		return "index.htm";
	}

	@GetMapping("/panel8")
	public ModelAndView mostrarFormulario() {
		return new ModelAndView("index");
	}
	

	
	
	
	@PostMapping("/crear")
	public String registrar(@RequestParam("numero") long numero , @RequestParam("nombre") String nombre , 
			@RequestParam("apellido") String apellido , @RequestParam("email") String email , 
			 @RequestParam("password") String password ,
			@RequestParam("password2") String password2) throws WebException{
		
		try {
		usuarioServices.registrar(numero, nombre, apellido,null, email,password, password2);
	
		return "redirect:/micuenta";
	}catch(Exception e){
		return "redirect:MiCuenta";
	}
	}
	
	
	
	

	
	@GetMapping("/panel7")
	public String login(@RequestParam(required = false)String error ,@RequestParam(required = false)String logout, ModelMap model) {
		if(error != null) {
			model.put("error", "usuario o clave incorrecto");
		}
		
		if(logout != null) {
			model.put("error", "ha salido correctamente de la plataforma");
		}
		return "index.htm";
	} 
	
	

	
	

	@GetMapping("/login")
	public ModelAndView mostrarlogin() {
		return new ModelAndView("login");
	}
	
	@GetMapping("/micuenta/{id}")
	public ModelAndView mostrarCuenta(@PathVariable("id")Integer id) {
		
		Optional<Usuario> usuario =	usuarioServices.buscarUsuarioPorID(id);
		
		Integer rol = usuario.get().getId_rol().getId_rol();
		if(rol == 1) {
			ModelAndView mav = new ModelAndView("Admin");
			mav.addObject("presupuesto" , presu.getAll());
			return mav;
		}
		
		ModelAndView mav2 = new ModelAndView("MiCuenta");
		mav2.addObject("presupuesto", presu.listadePresupuesto(id));
		 return mav2;
		

	}
}
