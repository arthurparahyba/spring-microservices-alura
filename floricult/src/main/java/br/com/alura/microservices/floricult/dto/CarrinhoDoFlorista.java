package br.com.alura.microservices.floricult.dto;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoDoFlorista {

	private String florista;
	
	private String enderecoFlorista;
	
	private LocalDate dataDaEntrega;
	
	private List<InfoDeCompra> informacoesDeCompra;
	
	private List<ProdutoDTO> produtos;
	
	private String couponDeEntrega;

	public String getFlorista() {
		return florista;
	}

	public void setFlorista(String florista) {
		this.florista = florista;
	}

	public List<InfoDeCompra> getInformacoesDeCompra() {
		if(this.informacoesDeCompra == null) {
			this.informacoesDeCompra = new ArrayList<InfoDeCompra>();
		}
		return informacoesDeCompra;
	}

	public void setInformacoesDeCompra(List<InfoDeCompra> informacoesDeCompra) {
		this.informacoesDeCompra = informacoesDeCompra;
	}

	public List<String> getNomesDosProdutosSelecionados() {
		return this.informacoesDeCompra.stream()
			.map(info -> info.getNome())
			.collect(Collectors.toList());
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}

	public String getEnderecoFlorista() {
		return enderecoFlorista;
	}

	public void setEnderecoFlorista(String enderecoFlorista) {
		this.enderecoFlorista = enderecoFlorista;
	}

	public String getCouponDeEntrega() {
		return couponDeEntrega;
	}

	public void setCouponDeEntrega(String couponDeEntrega) {
		this.couponDeEntrega = couponDeEntrega;
	}

	public Integer getMaiorTempoDePreparacao() {
		ProdutoDTO produtoComMaiorTempoDePreparo = produtos
				.stream()
				.max((p1, p2) -> p1.getTempoDePreparo().compareTo(p2.getTempoDePreparo())).get();
		
		return produtoComMaiorTempoDePreparo.getTempoDePreparo();
	}

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}
}
