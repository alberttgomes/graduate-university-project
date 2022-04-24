package com.placa.mae.placamae.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PeopleKids extends People {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long kisId;
	@Column
	private List<MaterialKids> materialKids;

	public PeopleKids() {
		super();
	}

	public PeopleKids(long peopleId, String nome, long idade, String dataNascimento) {
		super(peopleId, nome, idade, dataNascimento);
	}

	public PeopleKids(long kisId, List<MaterialKids> materialKids) {
		super();
		this.kisId = kisId;
		this.materialKids = materialKids;
	}

	public long getKisId() {
		return kisId;
	}

	public void setKisId(long kisId) {
		this.kisId = kisId;
	}

	public List<MaterialKids> getMaterialKids() {
		return materialKids;
	}

	public void setMaterialKids(List<MaterialKids> materialKids) {
		this.materialKids = materialKids;
	}

}
