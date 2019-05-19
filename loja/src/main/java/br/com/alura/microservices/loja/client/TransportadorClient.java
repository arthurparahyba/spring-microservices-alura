package br.com.alura.microservices.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.microservices.loja.dto.ConsultaDeEntregaDTO;
import br.com.alura.microservices.loja.dto.CouponDeEntregaDTO;
import br.com.alura.microservices.loja.dto.PedidoDTO;

@FeignClient("transportador")
public interface TransportadorClient {

	@RequestMapping(path="/entrega", method=RequestMethod.POST)
	CouponDeEntregaDTO efetuaReserva(PedidoDTO pedido);
	
}
