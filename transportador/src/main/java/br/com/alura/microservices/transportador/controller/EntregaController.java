package br.com.alura.microservices.transportador.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.transportador.api.CouponDeEntrega;
import br.com.alura.microservices.transportador.api.EntregaConsulta;
import br.com.alura.microservices.transportador.api.EntregaInfo;
import br.com.alura.microservices.transportador.api.PedidoDeEntrega;
import br.com.alura.microservices.transportador.service.EntregaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
	
	@Autowired
	private EntregaService entregaService;

	@ApiOperation(value="Consulta de orçamento de uma entrega a partir da origem e destino.")
	@RequestMapping(method=RequestMethod.GET)
	public EntregaInfo consulta(EntregaConsulta consulta) {
		EntregaInfo info = new EntregaInfo();
		info.setEnderecoOrigem(consulta.getEnderecoOrigem());
		info.setEnderecoDestino(consulta.getEnderecoDestino());
		info.setPreco(BigDecimal.valueOf(12.50));
		
		return info;
	}
	
	
	@ApiOperation(value="Efetua uma reserva de uma entrega em uma data e retorna o coupon da reserva.")
	@RequestMapping(method=RequestMethod.POST)
	public CouponDeEntrega efetuaReserva(@RequestBody PedidoDeEntrega pedido) {
		return entregaService.efetuaReserva(pedido);
	}
}
