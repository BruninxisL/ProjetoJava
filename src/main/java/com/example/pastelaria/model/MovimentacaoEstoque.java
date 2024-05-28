package com.example.pastelaria.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="movimetacao_estoque")
public class MovimentacaoEstoque {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod_movimentacao;
	
	private String tipoMovimentacao;
	
	@ManyToOne( cascade = CascadeType.REMOVE)
	@JoinColumn(name="cod_produto")
	private Produto cod_produto;
	
	private int quantidade;
	private LocalDateTime dataHora;
	
	
	public int getCod_movimentacao() {
		return cod_movimentacao;
	}
	public void setCod_movimentacao(int cod_movimentacao) {
		this.cod_movimentacao = cod_movimentacao;
	}
	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	
	public Produto getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(Produto cod_produto) {
		this.cod_produto = cod_produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
	
	
}
