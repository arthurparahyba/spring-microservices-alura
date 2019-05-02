package br.com.alura.microservices.floricult.dto;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompras {

	private Map<String, CarrinhoDoFlorista> carrinhosDosFloristas;

	public Map<String, CarrinhoDoFlorista> getCarrinhosDosFloristas() {
		if(this.carrinhosDosFloristas == null) {
			this.carrinhosDosFloristas = new HashMap<String, CarrinhoDoFlorista>();
		}
		return carrinhosDosFloristas;
	}

	public void setItens(Map<String, CarrinhoDoFlorista> itens) {
		this.carrinhosDosFloristas = itens;
	}
	
	
}
