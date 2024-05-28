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
@Table(name="funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_funcionario;
    
    private String nome;
    private int idade;
    private String sexo;
    private String cpf;
    private String endereco;

    @OneToMany(mappedBy = "cod_funcionario")
    private List<Comanda> comandasAtendidas = new ArrayList<>();



	public int getCod_funcionario() {
		return cod_funcionario;
	}

	public void setCod_funcionario(int cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Comanda> getComandasAtendidas() {
		return comandasAtendidas;
	}

	public void setComandasAtendidas(List<Comanda> comandasAtendidas) {
		this.comandasAtendidas = comandasAtendidas;
	}

    
    
}
