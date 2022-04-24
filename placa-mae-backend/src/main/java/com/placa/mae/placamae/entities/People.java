package com.placa.mae.placamae.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class People {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long peopleId;
	@Column
	private String nome;
	@Column
	private long idade;
	@Column
	private String dataNascimento;

	public People() {
		super();
	}

	public People(long peopleId, String nome, long idade, String dataNascimento) {
		super();
		this.peopleId = peopleId;
		this.nome = nome;
		this.idade = idade;
		this.dataNascimento = dataNascimento;
	}
	
	public long getPeopleId() {
		return peopleId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getIdade() {
		return idade;
	}

	public void setIdade(long idade) {
		this.idade = idade;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
