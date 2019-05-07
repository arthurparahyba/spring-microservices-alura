package br.com.alura.microservices.floricult.dto;

import java.time.LocalDate;
import java.util.List;


public class PedidoDeEntregaDTO {

	private String enderecoOrigem;
	private String enderecoDestino;
	private LocalDate dataParaTransporte;
	private List<InfoDeCompra> itensDeCompra;
	
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
	public LocalDate getDataParaTransporte() {
		return dataParaTransporte;
	}
	public void setDataParaTransporte(LocalDate data) {
		this.dataParaTransporte = data;
	}
	public List<InfoDeCompra> getItensDeCompra() {
		return itensDeCompra;
	}
	public void setItensDeCompra(List<InfoDeCompra> itensDeCompra) {
		this.itensDeCompra = itensDeCompra;
	}
}
