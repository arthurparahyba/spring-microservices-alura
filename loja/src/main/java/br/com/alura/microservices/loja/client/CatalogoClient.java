package br.com.alura.microservices.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.microservices.loja.dto.ProdutoDTO;

@FeignClient("fornecedor")
public interface CatalogoClient {

	@RequestMapping(method=RequestMethod.GET, value="/catalogo/{estado}/tempoDePreparo")
	Integer getTempoParaPreparo(
			@PathVariable("estado") String estado,
			@RequestParam("nomes") List<String> produtos);
	
	
}
