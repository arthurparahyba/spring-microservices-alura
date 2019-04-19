package br.com.alura.microservices.floricult.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.floricult.model.Florista;
import br.com.alura.microservices.floricult.repository.FloristaRepository;

@RestController
@RequestMapping(value="/v1/floristas")
public class FloristaControllerTemp {
	
	@Autowired
	private FloristaRepository floristaRepository;
	
	@RequestMapping(value="/{nome}")
	public Florista getFloristas(@PathVariable("nome") String nome) {
		return floristaRepository.findByNome(nome);
	}

}
