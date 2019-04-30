package br.com.alura.microservices.floricult.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.floricult.dto.ProdutoDTO;
import br.com.alura.microservices.floricult.service.CatalogoService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
	
	@Autowired
	private CatalogoService catalogService;
	
	@RequestMapping("/{estado}")
	public List<ProdutoDTO> getCatalogo(@PathVariable("estado") String estado){
		return catalogService.getProdutosPorEstado(estado);
	}
}
