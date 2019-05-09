package br.com.alura.microservices.floricult.service;

import org.springframework.stereotype.Service;

import br.com.alura.microservices.floricult.dto.CarrinhoDeComprasDTO;
import br.com.alura.microservices.floricult.dto.CompraRequestDTO;

@Service
public class CarrinhoDeCompraService {
	
	public CarrinhoDeComprasDTO getCarrinhoDeCompra(CompraRequestDTO compraDTO) {
		final CarrinhoDeComprasDTO carrinho = new CarrinhoDeComprasDTO();
		carrinho.setEnderecoDestino(compraDTO.getEnderecoDestino());
		carrinho.setDistribuidor(compraDTO.getDistribuidor());
		carrinho.setInformacoesDaCompra(compraDTO.getInformacoesDaCompra());
		return carrinho;
	}
}
