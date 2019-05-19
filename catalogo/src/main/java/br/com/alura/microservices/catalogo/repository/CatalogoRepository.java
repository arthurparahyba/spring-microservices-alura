package br.com.alura.microservices.catalogo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservices.catalogo.model.Produto;

@Repository
public interface CatalogoRepository extends CrudRepository<Produto, Long>{

	List<Produto> findByEstado(String estado);
}
