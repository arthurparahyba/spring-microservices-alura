package br.com.alura.microservices.fornecedor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservices.fornecedor.model.Produto;

@Repository
public interface CatalogoRepository extends CrudRepository<Produto, Long>{

	List<Produto> findByEstado(String estado);
}
