package br.com.alura.microservices.floricult.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.alura.microservices.floricult.dto.CarrinhoDeComprasDTO;
import br.com.alura.microservices.floricult.dto.CompraRequestDTO;
import br.com.alura.microservices.floricult.dto.CompraResponseDTO;
import br.com.alura.microservices.floricult.dto.CouponDeEntregaDTO;
import br.com.alura.microservices.floricult.dto.PedidoDTO;

@Service
public class CompraService {
	
	@Autowired
	private EntregaService entregaService;
	
	@Autowired
	private CarrinhoDeCompraService carrinhoService;
	
	@HystrixCommand(threadPoolKey="compraThreadPool")
	public CompraResponseDTO efetuaCompra(CompraRequestDTO compraDTO) {
		
		CarrinhoDeComprasDTO carrinho = carrinhoService.getCarrinhoDeCompra(compraDTO);
		PedidoDTO pedidoDeEntrega = entregaService.realizaPedido(carrinho);
		CouponDeEntregaDTO couponDeEntrega = entregaService.geraCouponDeEntrega(pedidoDeEntrega);
		
		CompraResponseDTO compraResponseDTO = new CompraResponseDTO();
		compraResponseDTO.setDataDaEntrega(pedidoDeEntrega.getDataParaTransporte().plusDays(couponDeEntrega.getTempoParaTransporte()));
		compraResponseDTO.setEnderecoDestino(couponDeEntrega.getDestino());
		compraResponseDTO.setEnderecoOrigem(couponDeEntrega.getOrigem());
		compraResponseDTO.setInformacoesDaCompra(carrinho.getInformacoesDaCompra());
		
		return compraResponseDTO;
	}
}
