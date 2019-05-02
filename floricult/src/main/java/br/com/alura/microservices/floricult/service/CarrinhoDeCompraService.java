package br.com.alura.microservices.floricult.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservices.floricult.dto.CarrinhoDeCompras;
import br.com.alura.microservices.floricult.dto.InfoDeCompra;
import br.com.alura.microservices.floricult.dto.ProdutoDTO;

@Service
public class CarrinhoDeCompraService {

	@Autowired
	private CatalogoService catalogoService;
	
	public CarrinhoDeCompras recuperaProdutos(List<InfoDeCompra> selecionados) {
		
		final CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		for(InfoDeCompra infoDeCompra : selecionados) {
			carrinho.getCarrinhosDosFloristas()
				.get(infoDeCompra.getFlorista())
				.getInformacoesDeCompra()
					.add(infoDeCompra);
		}
		
		carrinho.getCarrinhosDosFloristas()
			.forEach((florista, carrinhoFlorista) -> {
				List<String> nomeDosProdutos = carrinhoFlorista.getNomesDosProdutosSelecionados();
				
				List<ProdutoDTO> produtos = catalogoService.buscaProdutos(florista,nomeDosProdutos);
				carrinhoFlorista.setProdutos(produtos);
			});
		
		return carrinho;
	}
}
