package br.com.produtosloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produtosloja.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Integer>{

}
