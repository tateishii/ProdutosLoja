package br.com.produtosloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produtosloja.model.DetalhePedido;

public interface DetalhePedidoRepository extends JpaRepository<DetalhePedido, Integer> {

}
