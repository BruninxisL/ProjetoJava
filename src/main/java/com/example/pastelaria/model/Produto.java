package com.example.pastelaria.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="estoque")
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod_produto;
	
	private String nome;
	private int quantidade;
	private String unidade_medida;
	private double preco_custo;
	private LocalDateTime dataCadastro;
	
	
	 
	 
	public int getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getUnidade_medida() {
		return unidade_medida;
	}
	public void setUnidade_medida(String unidade_medida) {
		this.unidade_medida = unidade_medida;
	}
	public double getPreco_custo() {
		return preco_custo;
	}
	public void setPreco_custo(double preco_custo) {
		this.preco_custo = preco_custo;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
}
