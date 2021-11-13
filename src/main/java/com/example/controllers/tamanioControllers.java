package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Tamanio;
import com.example.services.TamanioServices;



@Controller
@RequestMapping("/tamanio")
public class tamanioControllers {
	
	@Autowired
	private TamanioServices servTamanio;
	
	@GetMapping("/ver-tamanio")
	public ModelAndView buscartamanio()throws Exception {
	 ModelAndView mav = new ModelAndView("tamanio-lista");
	 List<Tamanio> tamanio = servTamanio.buscarTamanio();
	 mav.addObject("tamanio",tamanio);
	 return mav;
	}
	
	@GetMapping("/crear-tamanio")
	public ModelAndView mostrarFormulario() {
		return new ModelAndView("tamanio-crear");
	}
	
	
	/*@PostMapping("/guardar-tamanio") 
	public String crearTamanio(@RequestParam String descripcion_tamanio, @RequestParam Integer tamanio, @RequestParam Integer tamanio_precio){
		try {
			
			servTamanio.tamanio(descripcion_tamanio, tamanio, tamanio_precio);
			
		}catch(Exception e) {
			 return "redirect:/tamanio/crear-tamanio/";
		}
		 return "redirect:/tamanio/ver-tamanio/";
	} */

	 
	 @GetMapping("/modificar")
	 public String modificarFormulario(@RequestParam Integer id_tamanio ,  ModelMap model) {
		 
		 Tamanio tamanio = servTamanio.buscarTamanioPorID(id_tamanio).get();
		 
		 model.addAttribute("tamanio", tamanio);
		 return "/tamanio-editar";
	 }
	 

	/* @PostMapping("/editar")
	 public String modificarTamanio( @RequestParam Integer id_tamanio ,@RequestParam String descripcion_tamanio, @RequestParam Integer tamanio, @RequestParam Integer tamanio_precio) {
		 
		 try {
			 
		 servTamanio.modificar(id_tamanio, descripcion_tamanio, tamanio, tamanio_precio);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/tamanio/ver-tamanio/";
	 
	 }*/
	 

	
	
}
