package br.com.alura.microservices.floricult.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Florista {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Basic(optional=false)
	private String endpoint;
	
	@Basic(optional=false)
	private String nome;
	
	@Basic(optional=false)
	private String contaEmpresarial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContaEmpresarial() {
		return contaEmpresarial;
	}

	public void setContaEmpresarial(String contaEmpresarial) {
		this.contaEmpresarial = contaEmpresarial;
	}
}
