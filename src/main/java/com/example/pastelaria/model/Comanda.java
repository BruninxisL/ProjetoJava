package com.example.pastelaria.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="comandas")
public class Comanda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_comanda;
	
	
	@ManyToOne
	@JoinColumn(name="cod_mesa")
	private Mesas cod_mesa;
	
	@ManyToOne
	@JoinColumn(name="cod_funcionario")
	private Funcionario cod_funcionario;
	
	private LocalDateTime dataAbertura;
	private LocalDateTime dateFechamento;
	private String status;
	
    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemComanda> itensComanda = new ArrayList<>();

    @OneToMany(mappedBy = "cod_comanda", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Conta> contas = new ArrayList<>();

    
    

	public int getCod_comanda() {
		return cod_comanda;
	}

	public void setCod_comanda(int cod_comanda) {
		this.cod_comanda = cod_comanda;
	}

	public Mesas getCod_mesa() {
		return cod_mesa;
	}

	public void setCod_mesa(Mesas cod_mesa) {
		this.cod_mesa = cod_mesa;
	}

	public Funcionario getCod_funcionario() {
		return cod_funcionario;
	}

	public void setCod_funcionario(Funcionario cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDateFechamento() {
		return dateFechamento;
	}

	public void setDateFechamento(LocalDateTime dateFechamento) {
		this.dateFechamento = dateFechamento;
	}

	public List<ItemComanda> getItensComanda() {
		return itensComanda;
	}

	public void setItensComanda(List<ItemComanda> itensComanda) {
		this.itensComanda = itensComanda;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}
