package com.example.controllers;

import java.util.List;
import java.util.Optional;

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
import com.example.entities.Disposicion;
import com.example.entities.Presupuesto;
import com.example.entities.Rubro;
import com.example.entities.Tamanio;
import com.example.entities.Usuario;
import com.example.services.AberturaServices;
import com.example.services.DisposicionServices;
import com.example.services.PresupuestoService;
import com.example.services.RubroServices;
import com.example.services.TamanioServices;
import com.example.services.UsuarioServices;


@Controller
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

@Autowired
private UsuarioServices servUsusario;

@Autowired
private DisposicionServices servDispo;

	

//@PreAuthorize("hasAnyRole('ROLE_USUARIO_REGISTRADO')")
@GetMapping("/ver-presupuesto")
public ModelAndView buscarpresupues() throws Exception{
    
    ModelAndView mav = new ModelAndView("/presupuesto-lista.html");
    List<Presupuesto> presupuesto = servPresu.getAll();
    mav.addObject("presupuesto", presupuesto);
    return mav;
}


	
	
	@GetMapping("/crear-presupuesto")
	public String crearPresupuesto( ModelMap modelo)throws Exception {
		List<Rubro> rubro = servRubro.buscarRubro(); 
		List<Abertura> abertura = servAbertura.buscarAbertura();
		List<Tamanio> tamanio = servTamanio.buscarTamanio();
		List<Disposicion> disposicion = servDispo.buscarDisposicion();
		//Usuario usuario = servUsusario.buscarUsuarioPorID(id).get();
		modelo.addAttribute("rubro", rubro); 
		modelo.addAttribute("abertura", abertura);
		modelo.addAttribute("tamanio", tamanio);
		//modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("disposicion", disposicion);
		return "/PresupuestadorFinal.htm";
	}
	
	
	@PostMapping("/guardar")
	public String sacarPresupuesto(@RequestParam Abertura abertura, @RequestParam Tamanio tamanio, 
			@RequestParam Rubro rubro , @RequestParam Usuario usuario, @RequestParam Disposicion disposicion) {
		
    servPresu.preciofinal(abertura, tamanio, rubro,usuario , disposicion  );
	
	return "redirect:/presupuesto/ver-presupuesto";
	}
	
}
