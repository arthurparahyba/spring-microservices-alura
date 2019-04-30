package br.com.alura.microservices.florista.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.florista.model.Produto;
import br.com.alura.microservices.florista.service.CatalogoService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
	
	@Autowired
	private CatalogoService catalogoService;

	@RequestMapping("/{estado}")
	public List<Produto> getCatalogo(@PathVariable("estado") String estado){
		return catalogoService.getCatalogoPorEstado(estado);
	}
}