package br.com.alura.microservices.floricult.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.alura.microservices.floricult.dto.CarrinhoDeCompras;
import br.com.alura.microservices.floricult.dto.CompraRequestDTO;
import br.com.alura.microservices.floricult.dto.CompraResponseDTO;
import br.com.alura.microservices.floricult.dto.CouponDeEntregaDTO;
import br.com.alura.microservices.floricult.dto.PedidoDeEntregaDTO;

@Service
public class CompraService {
	
	@Autowired
	private EntregaService entregaService;
	
	@HystrixCommand(threadPoolKey="compraThreadPool")
	public CompraResponseDTO efetuaCompra(CarrinhoDeCompras carrinho) {
		
		PedidoDeEntregaDTO pedidoDeEntrega = entregaService.geraPedidoDeEntrega(carrinho);
		CouponDeEntregaDTO couponDeEntrega = entregaService.geraCouponDeEntrega(pedidoDeEntrega);
		
		CompraResponseDTO compraResponseDTO = new CompraResponseDTO();
		compraResponseDTO.setDataDaEntrega(pedidoDeEntrega.getDataParaTransporte().plusDays(couponDeEntrega.getTempoParaTransporte()));
		compraResponseDTO.setEnderecoDestino(couponDeEntrega.getDestino());
		compraResponseDTO.setEnderecoOrigem(couponDeEntrega.getOrigem());
		compraResponseDTO.setInformacoesDaCompra(carrinho.getInformacoesDaCompra());
		
		return compraResponseDTO;
	}
	
}
