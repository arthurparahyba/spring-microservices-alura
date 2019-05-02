package br.com.alura.microservices.floricult.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.floricult.dto.CompraRequestDTO;
import br.com.alura.microservices.floricult.dto.CompraResponseDTO;
import br.com.alura.microservices.floricult.dto.InfoDeCompra;
import br.com.alura.microservices.floricult.dto.ProdutoDTO;
import br.com.alura.microservices.floricult.service.CatalogoService;
import br.com.alura.microservices.floricult.service.CompraService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
	
	@Autowired
	private CatalogoService catalogoService;
	
	@Autowired
	private CompraService compraService;
	
	@RequestMapping("/{estado}")
	public List<ProdutoDTO> getCatalogo(@PathVariable("estado") String estado){
		return catalogoService.getProdutosPorEstado(estado);
	}
	
	@RequestMapping(path="/compra", method=RequestMethod.POST)
	public CompraResponseDTO efetuaCompra(CompraRequestDTO compraDTO) {
		return compraService.efetuaCompra(compraDTO);
	}
}
