package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Abertura;

import com.example.entities.Presupuesto;
import com.example.entities.Rubro;
import com.example.entities.Tamanio;
import com.example.services.AberturaServices;
import com.example.services.PresupuestoService;
import com.example.services.RubroServices;
import com.example.services.TamanioServices;


@Controller
@PreAuthorize("hasAnyRole('ROLE_ADMIN_REGISTRADO')")
@RequestMapping("/presupuesto")
public class PresupuestoController {

@Autowired
private PresupuestoService servPresu;

@Autowired
private RubroServices servRubro;

@Autowired
private AberturaServices servAbertura;

@Autowired
private TamanioServices servTamanio;
	

@PreAuthorize("hasAnyRole('ROLE_USUARIO_REGISTRADO')")
@GetMapping("/ver-presupuesto")
public ModelAndView buscarlibro() throws Exception{
    
    ModelAndView mav = new ModelAndView("/presupuesto-lista");
    List<Presupuesto> presupuesto = servPresu.getAll();
    mav.addObject("presupuesto", presupuesto);
    return mav;
}


	
	
	@GetMapping("/crear-presupuesto")
	public String crearPresupuesto( ModelMap modelo)throws Exception {
		List<Rubro> rubro = servRubro.buscarRubro(); 
		List<Abertura> abertura = servAbertura.buscarAbertura();
		List<Tamanio> tamanio = servTamanio.buscarTamanio();
		
		modelo.addAttribute("rubro", rubro); 
		modelo.addAttribute("abertura", abertura);
		modelo.addAttribute("tamanio", tamanio);
		return ("/presupuesto");
	}
	
	
	@PostMapping("/guardar")
	public String sacarPresupuesto(@RequestParam Abertura abertura, @RequestParam Tamanio tamanio, @RequestParam Rubro rubro) {
		
    servPresu.preciofinal(abertura, tamanio, rubro);
	
	return "redirect:/presupuesto/ver-presupuesto";
	}
	
}
