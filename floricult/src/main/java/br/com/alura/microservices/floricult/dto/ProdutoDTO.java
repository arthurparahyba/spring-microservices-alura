package br.com.alura.microservices.floricult.dto;

import java.math.BigDecimal;

public class ProdutoDTO {

	private String nome;
	
	private String florista;
	
	private String fotos;
	
	private BigDecimal preco;
	
	private Integer tempoDePreparo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFotos() {
		return fotos;
	}

	public void setFotos(String fotos) {
		this.fotos = fotos;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public String getFlorista() {
		return florista;
	}

	public void setFlorista(String florista) {
		this.florista = florista;
	}
	
}
