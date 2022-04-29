package com.example.porto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.porto.model.Container;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long>{
	
	public List<Container> findAllByNomeContainingIgnoreCase(String nome);
	
	public List<Container> findAllByCategoriaContainingIgnoreCase(String categoria);
}
