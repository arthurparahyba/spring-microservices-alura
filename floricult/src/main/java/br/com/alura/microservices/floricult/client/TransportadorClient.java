package br.com.alura.microservices.floricult.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.microservices.floricult.dto.ConsultaDeEntregaDTO;
import br.com.alura.microservices.floricult.dto.CouponDeEntregaDTO;
import br.com.alura.microservices.floricult.dto.PedidoDTO;

@FeignClient("transportador")
public interface TransportadorClient {

	@RequestMapping(path="/entrega", method=RequestMethod.POST)
	CouponDeEntregaDTO efetuaReserva(PedidoDTO pedido);
	
}
