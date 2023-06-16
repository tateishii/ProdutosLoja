package br.com.produtosloja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalhePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddetalhepedido;
	
	@Column
	private Integer idproduto;
	
	@Column
	private Integer quantidade;
	
	@ManyToOne
	private Pedido idpedido;

	public DetalhePedido() {
	}

	public DetalhePedido(Integer iddetalhepedido, Integer idproduto, Integer quantidade, Pedido idpedido) {
		this.iddetalhepedido = iddetalhepedido;
		this.idproduto = idproduto;
		this.quantidade = quantidade;
		this.idpedido = idpedido;
	}

	public Integer getIddetalhepedido() {
		return iddetalhepedido;
	}

	public void setIddetalhepedido(Integer iddetalhepedido) {
		this.iddetalhepedido = iddetalhepedido;
	}

	public Integer getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(Integer idproduto) {
		this.idproduto = idproduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Pedido idpedido) {
		this.idpedido = idpedido;
	}
	
	
	
}
