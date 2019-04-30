package br.com.alura.microservices.florista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservices.florista.model.Produto;
import br.com.alura.microservices.florista.repository.CatalogoRepository;

@Service
public class CatalogoService {

	@Autowired
	private CatalogoRepository catalogoRepository;
	
	public List<Produto> getCatalogoPorEstado(String estado){
		return catalogoRepository.findByEstado(estado);
	}
}
