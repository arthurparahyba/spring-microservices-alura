package br.com.alura.microservices.floricult.dto;

import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoDeCompras {
	
	private String distribuidor;
	private String enderecoDestino;
	private List<InfoDeCompra> informacoesDaCompra;

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	public List<InfoDeCompra> getInfoDeCompra() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<InfoDeCompra> getInformacoesDaCompra() {
		return informacoesDaCompra;
	}

	public void setInformacoesDaCompra(List<InfoDeCompra> informacoesDaCompra) {
		this.informacoesDaCompra = informacoesDaCompra;
	}
	
	public List<String> getNomesDosProdutos(){
		return this.getInformacoesDaCompra().stream()
				.map(info -> info.getNome())
				.collect(Collectors.toList());
	}

}
