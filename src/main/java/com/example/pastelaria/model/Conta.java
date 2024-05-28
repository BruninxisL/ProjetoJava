package com.example.pastelaria.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="conta")
public class Conta {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int cod_conta;
	
	@ManyToOne
	@JoinColumn(name="cod_comanda")
	private Comanda cod_comanda;
	
	private double valorTotal;
	private String status;
	private String tipoPagamento;
	private LocalDateTime dataCriação;
	private LocalDateTime dataFechamento;
	
	public int getCod_conta() {
		return cod_conta;
	}
	public void setCod_conta(int cod_conta) {
		this.cod_conta = cod_conta;
	}
	public Comanda getCod_comanda() {
		return cod_comanda;
	}
	public void setCod_comanda(Comanda cod_comanda) {
		this.cod_comanda = cod_comanda;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public LocalDateTime getDataCriação() {
		return dataCriação;
	}
	public void setDataCriação(LocalDateTime dataCriação) {
		this.dataCriação = dataCriação;
	}
	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	
	
}
