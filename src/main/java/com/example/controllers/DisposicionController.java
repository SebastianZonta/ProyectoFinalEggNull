package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Disposicion;
import com.example.services.DisposicionServices;

@Controller
@RequestMapping("/disposicion")
public class DisposicionController {

	
	
	@Autowired
	private DisposicionServices dispServices;
	
	@GetMapping("/Listar")
	public ModelAndView buscardisposicion()throws Exception {
	 ModelAndView mav = new ModelAndView("Listar-disposicion");
	 List<Disposicion> disposicion = dispServices.listarTodos();
	 mav.addObject("disposicion",disposicion);
	 return mav;
	}
	
	@GetMapping("/Crear")
	public ModelAndView mostrarFormulario() {
		return new ModelAndView("disposicion-Crear");
	}
	
	@PostMapping("/Guardar")
	
	public String crearDisposicion(@RequestParam String descripcion_disposicion,@RequestParam Integer precio_disposicion)throws Exception {
		try {
			
			dispServices.registrar(descripcion_disposicion, precio_disposicion);
			
		}catch(Exception e) {
			 return "redirect:/disposicion/Crear/";
		}
		 return "redirect:/disposicion/Listar/";
	}

	@GetMapping("/Modificar")
	 public String modificarFormulario(@RequestParam Integer id ,  ModelMap model) {
		 
		 Disposicion disposicion = dispServices.buscarDisposicionPorID(id).get();
		 
		 model.addAttribute("disposion", disposicion);
		 return "/disposion-Modificar";
	 }
	
	 @PostMapping("/Editar")
	 public String modificarDisposicion(@RequestParam Integer id ,@RequestParam String descripcion_disposicion, @RequestParam Integer precio_disposicion) {
		 
		 try {
			 
		 dispServices.modificar(id, descripcion_disposicion,precio_disposicion);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/disposicion/Listar-disposicion/";
	 
	 }
	
	 @GetMapping("/Baja/{id}")
	 public String baja( @PathVariable("id") Integer id) {
		 
		 try {
			 
		 dispServices.desahibilitar(id);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/disposicion/Listar-disposicion/";
	 }

	 @GetMapping("/Alta/{id}")
	 public String alta( @PathVariable("id") Integer id) {
		 
		 try {
			 
		 dispServices.alta(id);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/disposicion/Listar-disposicion/";
	 }
	 
}
	
	
	

