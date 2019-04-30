package br.com.alura.microservices.transportador.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservices.transportador.api.CouponDeEntrega;
import br.com.alura.microservices.transportador.api.PedidoDeEntrega;
import br.com.alura.microservices.transportador.model.EntregaProgramada;
import br.com.alura.microservices.transportador.model.Item;
import br.com.alura.microservices.transportador.repository.EntregaRepository;

@Service
public class EntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	
	public CouponDeEntrega efetuaReserva(PedidoDeEntrega pedido) {
		
		EntregaProgramada entrega = new EntregaProgramada();
		entrega.setCodigo(UUID.randomUUID().toString());
		entrega.setDataDaEntrega(pedido.getData());
		entrega.setDestino(pedido.getEnderecoDestino());
		entrega.setOrigem(pedido.getEnderecoOrigem());
		
		pedido.getItensDeCompra()
			.stream()
			.forEach(itemDeCompra -> {
				Item item = new Item(itemDeCompra.getNome(), itemDeCompra.getQuantidade());
				entrega.getItensDeCompra().add(item);
			});
		
		entregaRepository.save(entrega);
		
		return new CouponDeEntrega()
				.comCoupon(entrega.getCodigo())
				.comOrigem(entrega.getOrigem())
				.comDestino(entrega.getDestino());
	}

}
