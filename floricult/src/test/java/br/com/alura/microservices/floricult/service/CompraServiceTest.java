package br.com.alura.microservices.floricult.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.alura.microservices.floricult.dto.CarrinhoDeCompras;
import br.com.alura.microservices.floricult.dto.CarrinhoDoFlorista;
import br.com.alura.microservices.floricult.dto.CompraRequestDTO;
import br.com.alura.microservices.floricult.dto.CompraResponseDTO;
import br.com.alura.microservices.floricult.dto.InfoDeCompra;
import br.com.alura.microservices.floricult.dto.ProdutoDTO;
import br.com.alura.microservices.floricult.model.Florista;
import br.com.alura.microservices.floricult.repository.FornecedorRepository;

@RunWith(MockitoJUnitRunner.class)
public class CompraServiceTest {
	
	@Mock
	private FornecedorRepository fornecedorRepository;

	@Mock
	private CarrinhoDeCompraService carrinhoDeCompraService;
	
	@InjectMocks
	private CompraService compraService;
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void compraDeUmProduto() {
		
		final String enderecoDestino = "endereço de teste";
		final String nomeProduto = "rosa";
		final String nomeFlorista = "florista";
		
		final InfoDeCompra info = new InfoDeCompra();
		info.setFlorista(nomeFlorista);
		info.setNome(nomeProduto);
		info.setQuantidade(10);
		final List informacoesDeCompra = new ArrayList<InfoDeCompra>();
		informacoesDeCompra.add(info);
		
		{
			ProdutoDTO produto = new ProdutoDTO();
			produto.setFlorista(nomeFlorista);
			produto.setNome(nomeProduto);
			produto.setPreco(BigDecimal.valueOf(11.90));
			produto.setTempoDePreparo(3);
			List produtos = new ArrayList<ProdutoDTO>();
			produtos.add(produto);
			
			CarrinhoDoFlorista carrinhoFlorista = new CarrinhoDoFlorista();
			carrinhoFlorista.setFlorista(nomeFlorista);
			carrinhoFlorista.setInformacoesDeCompra(informacoesDeCompra);
			carrinhoFlorista.setProdutos(produtos);
			
			CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
			carrinho.getCarrinhosDosFloristas().put(nomeFlorista, carrinhoFlorista);
			
			Mockito.when(carrinhoDeCompraService.recuperaProdutos(Mockito.any())).thenReturn(carrinho);
		}
		
		{
			Florista florista = new Florista();
			florista.setNome("florista");
			Mockito.when(fornecedorRepository.findByNome("florista")).thenReturn(florista);
		}
		
		CompraRequestDTO compra = new CompraRequestDTO();
		compra.setEnderecoDestino(enderecoDestino);
		compra.setInformacoesDaCompra(informacoesDeCompra);
		
		CompraResponseDTO compraResponse = compraService.efetuaCompra(compra);
		
		assertEquals(enderecoDestino, compraResponse.getEnderecoDestino());
		assertEquals(1, compraResponse.getInformacoesDaCompra().size());
		
	}

}
