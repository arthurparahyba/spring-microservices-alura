package br.com.alura.microservices.transportador.api;

public class CouponDeEntrega {

	private String coupon;
	private String origem;
	private String destino;
	
	public String getCoupon() {
		return coupon;
	}
	public CouponDeEntrega comCoupon(String coupon) {
		this.coupon = coupon;
		return this;
	}
	public String getOrigem() {
		return origem;
	}
	public CouponDeEntrega comOrigem(String origem) {
		this.origem = origem;
		return this;
	}
	public String getDestino() {
		return destino;
	}
	public CouponDeEntrega comDestino(String destino) {
		this.destino = destino;
		return this;
	}
}
