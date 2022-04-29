package com.example.porto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.porto.model.Movimentacao;
import com.example.porto.repository.MovimentacaoRepository;

@RestController
@RequestMapping("/movimentacoes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoRepository repository;

	@GetMapping
	public ResponseEntity<List<Movimentacao>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movimentacao> getById(@PathVariable Long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("nome/{nome}")
	public ResponseEntity<List<Movimentacao>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Movimentacao> post(@Valid @RequestBody Movimentacao movimentacao){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(movimentacao));
	}
	
	@PutMapping
	public ResponseEntity<Movimentacao> put(@Valid @RequestBody Movimentacao movimentacao){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(movimentacao));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
