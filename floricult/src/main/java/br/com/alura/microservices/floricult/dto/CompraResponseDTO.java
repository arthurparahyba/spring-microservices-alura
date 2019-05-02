package br.com.alura.microservices.floricult.dto;

import java.time.LocalDate;
import java.util.List;

public class CompraResponseDTO {

	private LocalDate dataDaEntrega;
	private String enderecoOrigem;
	private String enderecoDestino;
	private List<InfoDeCompra> informacoesDaCompra;

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}
	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}
	public String getEnderecoOrigem() {
		return enderecoOrigem;
	}
	public void setEnderecoOrigem(String enderecoOrigem) {
		this.enderecoOrigem = enderecoOrigem;
	}
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
