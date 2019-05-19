package br.com.alura.microservices.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.microservices.loja.dto.ProdutoDTO;

@FeignClient("florista")
public interface CatalogoClient {

	@RequestMapping(method=RequestMethod.GET, value="/catalogo/{florista}/tempoDePreparo")
	Integer getTempoParaPreparo(
			@PathVariable("florista") String florista,
			@RequestParam("nomes") List<String> produtos);
	
	
}
