package com.example.pastelaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="iten_comanda")
public class ItemComanda {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int cod_itenComanda;
	
	@ManyToOne
	@JoinColumn(name="cod_comanda")
	private Comanda comanda;
	
	@ManyToOne
	@JoinColumn(name="cod_prato")
	private Pratos cod_prato;
	
	private int quantidade;
	private double precoUnitario;
	private String observacoes;
	
	public int getCod_itenComanda() {
		return cod_itenComanda;
	}
	public void setCod_itenComanda(int cod_itenComanda) {
		this.cod_itenComanda = cod_itenComanda;
	}
	public Comanda getComanda() {
		return comanda;
	}
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
	public Pratos getCod_prato() {
		return cod_prato;
	}
	public void setCod_prato(Pratos cod_prato) {
		this.cod_prato = cod_prato;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
}
