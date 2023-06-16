package br.com.produtosloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produtosloja.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos,Integer> {

}
