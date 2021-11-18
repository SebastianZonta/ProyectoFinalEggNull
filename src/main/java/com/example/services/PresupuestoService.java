package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Abertura;
import com.example.entities.Presupuesto;
import com.example.entities.Rubro;
import com.example.entities.Tamanio;
import com.example.repositories.PresupuestoRepositories;



@Service
public class PresupuestoService {

@Autowired
private PresupuestoRepositories rpsPresupuesto;

@Autowired
private AberturaServices servAbertura;

@Autowired
private TamanioServices servTamanio;
@Autowired
private RubroServices servRubro;





@Transactional
public void preciofinal(Abertura abertura, Tamanio tamanio , Rubro rubro) {
	
	Presupuesto presu = new Presupuesto();
	
	servAbertura.precioabertura(abertura);
	presu.setId_abertura(abertura);
	abertura.getPrecio_abertura();
	
	/*servTamanio.precioabertura(tamanio);*/
	presu.setId_tamanio(tamanio);
	tamanio.getPrecio_tamanio();
	
	servRubro.precio(rubro);
	presu.setId_rubro(rubro);
	rubro.getPrecio_rubro();
	
	presu.setPrecioTotal(abertura.getPrecio_abertura() + tamanio.getPrecio_tamanio() + rubro.getPrecio_rubro());
	
	rpsPresupuesto.save(presu);
	
	
}

@Transactional
public List<Presupuesto> listadePresupuesto(Integer id){
	return rpsPresupuesto.listaPresupuesto(id);
}


@Transactional(readOnly = true)
public List<Presupuesto> getAll()
{
	return  rpsPresupuesto.findAll();
}

	
}
