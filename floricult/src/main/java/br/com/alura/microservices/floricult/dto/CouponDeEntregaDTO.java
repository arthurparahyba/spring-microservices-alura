package br.com.alura.microservices.floricult.dto;

public class CouponDeEntregaDTO {

	private String coupon;
	private String origem;
	private String destino;
	private Integer tempoParaTransporte;
	
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Integer getTempoParaTransporte() {
		return tempoParaTransporte;
	}
	public void setTempoParaTransporte(Integer tempoParaTransporte) {
		this.tempoParaTransporte = tempoParaTransporte;
	}
}
