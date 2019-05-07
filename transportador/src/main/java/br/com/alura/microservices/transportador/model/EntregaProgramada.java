package br.com.alura.microservices.transportador.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class EntregaProgramada {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	private String codigo;
	
	@Basic
	private LocalDate dataDaEntrega;
	
	@OneToMany(cascade=CascadeType.ALL) @JoinColumn(name="entrega_id")
	private List<Item> itensDeCompra;
 	
	@Basic
	private String origem;
	
	@Basic
	private String destino;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
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

	public List<Item> getItensDeCompra() {
		if(this.itensDeCompra == null) {
			this.itensDeCompra = new ArrayList<Item>();
		}
		return itensDeCompra;
	}

	public void setItensDeCompra(List<Item> itensDeCompra) {
		this.itensDeCompra = itensDeCompra;
	}
}
