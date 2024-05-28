package com.example.pastelaria.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="mesas")
public class Mesas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_mesa;
	private int numero_mesa;
	private String status;
	
	@OneToMany(mappedBy = "cod_mesa")
	private List<Comanda> comandas  = new ArrayList<>();

	public int getCod_mesa() {
		return cod_mesa;
	}

	public void setCod_mesa(int cod_mesa) {
		this.cod_mesa = cod_mesa;
	}

	public int getNumero_mesa() {
		return numero_mesa;
	}

	public void setNumero_mesa(int numero_mesa) {
		this.numero_mesa = numero_mesa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}
	
	
}
