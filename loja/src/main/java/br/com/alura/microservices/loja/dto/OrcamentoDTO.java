package br.com.alura.microservices.loja.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrcamentoDTO {

	private String enderecoOrigem;
	private String enderecoDestino;
	private List<InfoDeCompra> informacoesDaCompra;
	private BigDecimal preco;
	private LocalDate dataPrevistaParaEntrega;
	
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
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public LocalDate getDataPrevistaParaEntrega() {
		return dataPrevistaParaEntrega;
	}
	public void setDataPrevistaParaEntrega(LocalDate dataPrevistaParaEntrega) {
		this.dataPrevistaParaEntrega = dataPrevistaParaEntrega;
	}
}
