package br.com.alura.microservices.loja.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservices.loja.model.Florista;

@Repository
public interface DistribuidorRepository extends CrudRepository<Florista, Long>{

	Florista findByNome(String nome);
	
}
