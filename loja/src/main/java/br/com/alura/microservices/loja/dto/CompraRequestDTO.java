package br.com.alura.microservices.loja.dto;

import java.util.List;

public class CompraRequestDTO {

	private String enderecoDestino;
	private String distribuidor;
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

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}
	
	
}
