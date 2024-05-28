package com.example.pastelaria.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Pratos")
public class Pratos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_prato;
	private String nome;
	private double preco;
	@Column(columnDefinition ="TEXT")
	private String descricao;
	
	
	@OneToMany(mappedBy = "cod_prato", cascade = CascadeType.REMOVE)
	private List<ItensPrato> itens = new ArrayList<>();


	public int getCod_prato() {
		return cod_prato;
	}


	public void setCod_prato(int cod_prato) {
		this.cod_prato = cod_prato;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<ItensPrato> getItens() {
		return itens;
	}


	public void setItens(List<ItensPrato> itens) {
		this.itens = itens;
	}
	
	
}
