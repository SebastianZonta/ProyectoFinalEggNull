package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Rubro;
import com.example.errores.WebException;
import com.example.services.RubroServices;

@Controller
@RequestMapping("/rubro")
public class RubroController {
	@Autowired	
	private RubroServices service;
	
	@GetMapping("/Listar")
	public ModelAndView listar()
	{
		ModelAndView mav=new ModelAndView("/rubro-Listar");
		List<Rubro> listaRubros = service.getAll();
		mav.addObject(listaRubros);
		return mav;
	}
	@GetMapping("/Eliminar/{id}")
	public String Eliminar(@PathVariable("id") Integer id)
	{
		try {
			service.deshabilitar(id, true);
		} catch (WebException e) {
			
			
		}
		return "redirect:/rubro/Listar";
	}
	@GetMapping("Crear")
	public ModelAndView CrearRubro()
	{
		return new ModelAndView("rubro-Crear");
	}
	
	@PostMapping("Guardar")
	public String GuardarRubro(@RequestParam String descripcion_tipo,@RequestParam Integer precio_rubro)
	{
		try {
			service.guardar(descripcion_tipo, precio_rubro);
			return "redirect:/rubro/Listar";
		} catch (Exception e) {
			return "redirect:/rubro/Crear";
		}
	}
	@GetMapping("Modificar")
	public String ModificarRubro(@RequestParam Integer id, @RequestParam String descripcion_tipo,@RequestParam Integer precio_rubro)
	{
		try {
			service.modificar(precio_rubro, descripcion_tipo, precio_rubro);
			return "redirect:/rubro/Listar";
		} catch (WebException e) {
			// TODO Auto-generated catch block
			return "redirect:/rubro/Crear";
		}
		
	}
	public String AltaRubro(@RequestParam Integer id)
	{
	try {
		service.deshabilitar(id, false);
		return "redirect:/rubro/Listar";
	} catch (Exception e) {
		return "redirect:/rubro/rubro-Crear";
	}	
	}
	
	
	
	
	
	
	
}
