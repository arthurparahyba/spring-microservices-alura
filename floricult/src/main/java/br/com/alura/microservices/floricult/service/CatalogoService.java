package br.com.alura.microservices.floricult.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import br.com.alura.microservices.floricult.dto.ProdutoDTO;

@Service
public class CatalogoService {
	
	@Autowired
	private RestTemplate restTemplate;

	private List<ProdutoDTO> callGetProdutosPorEstado(String estado) {
		ResponseEntity<List<ProdutoDTO>> result = restTemplate.exchange("http://florista/catalogo/{estado}", 
				HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<ProdutoDTO>>(){} ,
				estado);
		
		return result.getBody();
	}
	
	@HystrixCommand(fallbackMethod="fallbackProdutosPorEstado", threadPoolKey="produtosPorEstadoThreadPool")
	public List<ProdutoDTO> getProdutosPorEstado(String estado){
		
		List<ProdutoDTO> produtos = callGetProdutosPorEstado(estado);
		
		return produtos;
	}
	
	public List<ProdutoDTO> fallbackProdutosPorEstado(String estado) {
		
		ProdutoDTO produto = new ProdutoDTO();
		produto.setNome("Não foi possível buscar os produtos para o "+estado);
		
		return Arrays.asList(produto);
	}
}
