package br.com.alura.microservices.floricult.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservices.floricult.dto.CarrinhoDeCompras;
import br.com.alura.microservices.floricult.dto.CarrinhoDoFlorista;
import br.com.alura.microservices.floricult.dto.CompraRequestDTO;
import br.com.alura.microservices.floricult.dto.CompraResponseDTO;
import br.com.alura.microservices.floricult.repository.FornecedorRepository;

@Service
public class CompraService {
	
	@Autowired
	private CarrinhoDeCompraService carrinhoDeCompraService;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public CompraResponseDTO efetuaCompra(CompraRequestDTO compraDTO) {
		if(compraDTO == null || compraDTO.getInformacoesDaCompra() == null || compraDTO.getInformacoesDaCompra().isEmpty()) {
			throw new RuntimeException();
		}
		
		if(compraDTO.getEnderecoDestino() == null) {
			throw new RuntimeException();
		}
		//PS: Próxima tarefa: Definir a modelagem antes de continuar.
		//1) Busca as informações dos produtos para calcular o tempo de entrega.
		//2) Contrata o entregador. Este nos retorna um coupon.
		//3) Compra os produtos no florista passando o coupon do entregador.
		CarrinhoDeCompras carrinhoDeCompras = carrinhoDeCompraService.recuperaProdutos(compraDTO.getInformacoesDaCompra());
		carrinhoDeCompras.getCarrinhosDosFloristas().forEach(this::finalizaCarrinho);
		
		return null;
	}
	
	private void finalizaCarrinho(String florista, CarrinhoDoFlorista carrinho) {
		String endereco = fornecedorRepository.findByNome(florista).getEndereco();
		carrinho.setEnderecoFlorista(endereco);
		
		LocalDate dataDaEntrega = LocalDate.now().plusDays(carrinho.getMaiorTempoDePreparacao());
		carrinho.setDataDaEntrega(dataDaEntrega);
		
		
	}
	
}
