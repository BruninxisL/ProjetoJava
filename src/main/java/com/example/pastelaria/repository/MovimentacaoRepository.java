package com.example.pastelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.pastelaria.model.MovimentacaoEstoque;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEstoque, Integer>{
	
}
