package br.com.alura.microservices.floricult.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservices.floricult.model.Florista;

@Repository
public interface FloristaRepository extends CrudRepository<Florista, Long>{

	public Florista findByNome(String nome);
}
