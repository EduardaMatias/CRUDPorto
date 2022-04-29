package com.example.porto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.porto.model.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{

	public List<Movimentacao> findAllByNomeContainingIgnoreCase(String nome); /*buscar por tipo de movimentação*/
}
