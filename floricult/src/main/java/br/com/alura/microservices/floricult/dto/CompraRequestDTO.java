package br.com.alura.microservices.floricult.dto;

import java.util.List;

public class CompraRequestDTO {

	private String enderecoDestino;
	
	private List<InfoDeCompra> informacoesDaCompra;

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	public List<InfoDeCompra> getInformacoesDaCompra() {
		return informacoesDaCompra;
	}

	public void setInformacoesDaCompra(List<InfoDeCompra> informacoesDaCompra) {
		this.informacoesDaCompra = informacoesDaCompra;
	}
	
	
}
