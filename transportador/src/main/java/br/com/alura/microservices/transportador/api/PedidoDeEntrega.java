package br.com.alura.microservices.transportador.api;

import java.time.LocalDate;
import java.util.List;

public class PedidoDeEntrega {

	private String enderecoOrigem;
	private String enderecoDestino;
	private LocalDate data;
	private List<ItemDeCompra> itensDeCompra;
	
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
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public List<ItemDeCompra> getItensDeCompra() {
		return itensDeCompra;
	}
	public void setItensDeCompra(List<ItemDeCompra> itensDeCompra) {
		this.itensDeCompra = itensDeCompra;
	}
	
	
}
