package br.com.produtosloja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtosloja.model.DetalhePedido;
import br.com.produtosloja.repository.DetalhePedidoRepository;

@RestController
@RequestMapping("/api/v1/orderdetail/")
public class DetalhePedidoController {

	@Autowired
	private DetalhePedidoRepository dpr;
	
	@GetMapping("/list")
	public ResponseEntity<Object> list(){
		try {
			return ResponseEntity.status(200).body(dpr.findAll());
		}
		catch(Exception e) {
			return ResponseEntity.status(500).body("Erro ao carregar dados -> "+e.getMessage());
		}
	}
	@PostMapping("/insert")
	public ResponseEntity<Object> insert(@RequestBody DetalhePedido detalhe){
		try {
			dpr.save(detalhe);
			return ResponseEntity.status(201).body("Detalhe inserido");
		}
		catch(Exception e) {
			return ResponseEntity.status(400)
					.body("Erro ao tentar inserir detalhe. "+e.getMessage());
		}
	}
}

















