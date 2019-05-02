package br.com.alura.microservices.floricult.dto;

public class InfoDeCompra {

	private String nome;
	
	private String florista;
	
	private int quantidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFlorista() {
		return florista;
	}

	public void setFlorista(String florista) {
		this.florista = florista;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
