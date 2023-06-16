package br.com.produtosloja.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtosloja.model.Produtos;
import br.com.produtosloja.repository.ProdutosRepository;

@RestController
@RequestMapping("/api/v1/products")
public class ProdutosController {

	//Importar o repository com uma auto instanciação
	@Autowired
	private ProdutosRepository pr;
	
	//listar os produtos
	@GetMapping("/list")
	public ResponseEntity<Object> list(){
		try {
			return ResponseEntity.status(200).body(pr.findAll());
		}
		catch(Exception e) {
			return ResponseEntity.status(500).body("Erro ao processar sua solicitação");
		}
	}
	
	//cadastar produtos
	@PostMapping("/insert")
	public ResponseEntity<Object> insert(@RequestBody Produtos produtos) {
		try {
			pr.save(produtos);
			return ResponseEntity.status(201).body("Produto cadastrado. IdProduto: "+produtos.getIdproduto()); 
		}
		catch(Exception e) {
			return ResponseEntity.status(400).body("Erro ao tentar cadastrar ->"+e.getMessage()); 
		}
		
	}

	//atualizar produto
	@PutMapping("/update/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public String update(@PathVariable Integer id, @RequestBody Produtos produtos) {
		String msg="";
		Optional<Produtos> prod = pr.findById(id);
		
		if(prod.isPresent()) {
			produtos.setIdproduto(id);
			pr.save(produtos);
			msg = "Produto atualizado";
		}
		else {
			msg = "Produto não encontrado";
		}
		return msg;
	}
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String delete(@PathVariable Integer id) {
		pr.deleteById(id);
		return "Dados apgados";
	}
	
}


