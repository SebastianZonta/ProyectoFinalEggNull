package com.example.controllers;

import java.util.List;
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

import com.example.entities.Abertura;
import com.example.services.AberturaServices;

@Controller
@RequestMapping("/abertura")
public class AberturaControlador {
	@Autowired
	private AberturaServices aberturaServices;

	/*
	@GetMapping("/listar")
	public ModelAndView buscarAberturaPorID() {

		ModelAndView mav = new ModelAndView("/Listar-abertura");
		List<Abertura> abertura = aberturaServices.getAll();
		mav.addObject("abertura", abertura);
		return mav;

	}
	
	 @GetMapping("/crear")
	 public ModelAndView mostrarFormulario() {
		 return new ModelAndView("/Crear-abertura");
	 }
	
	@PostMapping("/guardar")
	public String guardar(@RequestParam String id_abertura, @RequestParam String descripcion_abertura, @RequestParam Integer precio_abertura, @RequestParam boolean alta, @RequestParam ("abertura") Abertura abertura ) {
		try {
			aberturaServices.guardar(precio_abertura, descripcion_abertura, precio_abertura); 
				
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			return "redirect:/abertura/Listar";
		
		}

	 @GetMapping("/modificar")
	 public String modificar(@RequestParam Integer id_abertura, ModelMap model) {
		 
		 Optional<Abertura> abertura = aberturaServices.buscarAberturaPorID(id_abertura);
		 model.addAttribute("abertura", abertura);
		 return "redirect:/abertura/Listar";
	 }
	 

	 @PostMapping("/editar")
	 public String modificar( @RequestParam Integer id_abertura ,@RequestParam String descripcion_abertura,@RequestParam String precio_abertura) {
		 
		 try {
			 
		 aberturaServices.modificar(id_abertura, descripcion_abertura, id_abertura);
		 return "redirect:/abertura/Listar";
		 }catch(Exception e){
			 return "redirect:/abertura/abertura-Editar";
		 }
	 }    
	 
	 @GetMapping("/Baja/{id}")
	 public String baja( @PathVariable("id") Integer id_abertura) {
		 
		 try {
			 
		 aberturaServices.DarBaja(id_abertura);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/abertura/abertura-Listar/";
	 }

	 @GetMapping("/Alta/{id}")
	 public String alta( @PathVariable("id") Integer id_abertura) {
		 
		 try {
			 
		 aberturaServices.DarAlta(id_abertura);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/autor/abertura-Listar/";
	 }
	 
	 */
}













