package br.com.alura.microservices.floricult.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.microservices.floricult.dto.CouponDeEntregaDTO;
import br.com.alura.microservices.floricult.dto.PedidoDeEntregaDTO;

@FeignClient("transportador")
public interface TransportadorClient {

	@RequestMapping(method=RequestMethod.POST)
	CouponDeEntregaDTO efetuaReserva(PedidoDeEntregaDTO pedido);
}
