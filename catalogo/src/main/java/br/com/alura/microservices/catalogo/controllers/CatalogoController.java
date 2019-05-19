package br.com.alura.microservices.catalogo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.catalogo.model.Produto;
import br.com.alura.microservices.catalogo.service.CatalogoService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
	
	private Logger LOG = LoggerFactory.getLogger(CatalogoController.class);
	
	@Autowired
	private CatalogoService catalogoService;

	@RequestMapping("/{estado}")
	public List<Produto> getCatalogo(@PathVariable("estado") String estado){
		LOG.info("Buscando catalogo do estado {}", estado);
		return catalogoService.getCatalogoPorEstado(estado);
	}
	
	@RequestMapping(path="/{florista}/tempoDePreparo", method=RequestMethod.GET)
	public Integer getTempoDePreparo(@RequestParam("nomes")List<String> nomeProdutos){
		return 3;
	}
}
