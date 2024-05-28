package com.example.pastelaria.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pastelaria.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	Produto findById(int id);
}
