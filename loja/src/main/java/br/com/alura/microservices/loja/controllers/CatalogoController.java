package br.com.alura.microservices.loja.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.loja.dto.CompraRequestDTO;
import br.com.alura.microservices.loja.dto.CompraResponseDTO;
import br.com.alura.microservices.loja.dto.ProdutoDTO;
import br.com.alura.microservices.loja.service.CatalogoService;
import br.com.alura.microservices.loja.service.CompraService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
	
	private Logger LOG = LoggerFactory.getLogger(CatalogoController.class);
	
	@Autowired
	private CatalogoService catalogoService;
	
	@Autowired
	private CompraService compraService;
	
	@RequestMapping("/{estado}")
	public List<ProdutoDTO> getCatalogo(@PathVariable("estado") String estado){
		LOG.info("Buscando produtos por região: {}", estado);
		return catalogoService.getProdutosPorEstado(estado);
	}
	
	@RequestMapping(path="/compra", method=RequestMethod.POST)
	public CompraResponseDTO efetuaCompra(@RequestBody CompraRequestDTO compraDTO) {
		
		if(compraDTO == null || compraDTO.getInformacoesDaCompra() == null || compraDTO.getInformacoesDaCompra().isEmpty()) {
			throw new RuntimeException();
		}
		
		if(compraDTO.getEnderecoDestino() == null) {
			throw new RuntimeException();
		}
		
		return compraService.efetuaCompra(compraDTO);
	}
}
