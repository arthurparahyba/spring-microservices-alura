package br.com.alura.microservices.floricult.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservices.floricult.client.TransportadorClient;
import br.com.alura.microservices.floricult.dto.CarrinhoDeCompras;
import br.com.alura.microservices.floricult.dto.CouponDeEntregaDTO;
import br.com.alura.microservices.floricult.dto.PedidoDeEntregaDTO;
import br.com.alura.microservices.floricult.repository.DistribuidorRepository;

@Service
public class EntregaService {

	@Autowired
	private DistribuidorRepository fornecedorRepository;
	
	@Autowired
	private CatalogoService catalogoService;
	
	@Autowired
	private TransportadorClient transportadorClient;

	public PedidoDeEntregaDTO geraPedidoDeEntrega(CarrinhoDeCompras carrinho) {
		
		final String enderecoOrigem = fornecedorRepository.findByNome(carrinho.getDistribuidor()).getEndereco();
		final String enderecoDestino = carrinho.getEnderecoDestino();
		Integer tempoDePreparo = catalogoService.getTempoParaPreparo(carrinho);
		final LocalDate dataParaTransporte = LocalDate.now().plusDays(tempoDePreparo);
		
		PedidoDeEntregaDTO preditoDeEntrega = new PedidoDeEntregaDTO();
		preditoDeEntrega.setEnderecoOrigem(enderecoOrigem);
		preditoDeEntrega.setEnderecoDestino(enderecoDestino);
		preditoDeEntrega.setDataParaTransporte(dataParaTransporte);
		preditoDeEntrega.setItensDeCompra(carrinho.getInformacoesDaCompra());
		return preditoDeEntrega;
	}

	public CouponDeEntregaDTO geraCouponDeEntrega(PedidoDeEntregaDTO pedidoDeEntrega) {
		return transportadorClient.efetuaReserva(pedidoDeEntrega);
	}
}
