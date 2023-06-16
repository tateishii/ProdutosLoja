package br.com.produtosloja.model;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpedido;
	
	@Column
	private Integer idusuario;
	

	@Column
	private Date datapedido;

	public Pedido() {
	}

	public Pedido(Integer idpedido, Integer idusuario, Date datapedido) {
		this.idpedido = idpedido;
		this.idusuario = idusuario;
		this.datapedido = datapedido;
	}

	public Integer getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Date getDatapedido() {
		return datapedido;
	}

	public void setDatapedido(Date datapedido) {
		this.datapedido = datapedido;
	}
	
	
}
