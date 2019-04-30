package br.com.alura.microservices.transportador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservices.transportador.model.EntregaProgramada;

@Repository
public interface EntregaRepository extends CrudRepository<EntregaProgramada, Long>{

	
	
}
