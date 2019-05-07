package br.com.alura.microservices.floricult.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservices.floricult.model.Florista;

@Repository
public interface DistribuidorRepository extends CrudRepository<Florista, Long>{

	Florista findByNome(String nome);
	
}
