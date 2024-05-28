package com.example.pastelaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="itens_prato")
public class ItensPrato {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod_itensPrato;
	
	@ManyToOne
	@JoinColumn(name="cod_estoque")
	private Produto cod_estoque;
	
	@ManyToOne
	@JoinColumn(name="cod_prato")
	private Pratos cod_prato;
	
	private int quantidadePorPrato;

	public int getCod_itensPrato() {
		return cod_itensPrato;
	}

	public void setCod_itensPrato(int cod_itensPrato) {
		this.cod_itensPrato = cod_itensPrato;
	}

	public Produto getCod_estoque() {
		return cod_estoque;
	}

	public void setCod_estoque(Produto cod_estoque) {
		this.cod_estoque = cod_estoque;
	}

	public Pratos getCod_prato() {
		return cod_prato;
	}

	public void setCod_prato(Pratos cod_prato) {
		this.cod_prato = cod_prato;
	}

	public int getQuantidadePorPrato() {
		return quantidadePorPrato;
	}

	public void setQuantidadePorPrato(int quantidadePorPrato) {
		this.quantidadePorPrato = quantidadePorPrato;
	}

	
	
}
