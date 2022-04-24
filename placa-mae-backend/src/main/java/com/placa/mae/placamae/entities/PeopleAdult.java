package com.placa.mae.placamae.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PeopleAdult extends People {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adultId;
	@Column
	private List<MaterialAdult> materialAdult;

	public PeopleAdult() {
		super();
	}

	public PeopleAdult(long peopleId, String nome, long idade, String dataNascimento) {
		super(peopleId, nome, idade, dataNascimento);
	}

	public long getAdultId() {
		return adultId;
	}

	public void setAdultId(long adultId) {
		this.adultId = adultId;
	}

	public List<MaterialAdult> getMaterialAdult() {
		return materialAdult;
	}

	public void setMaterialAdult(List<MaterialAdult> materialAdult) {
		this.materialAdult = materialAdult;
	}

}
