package com.placa.mae.placamae.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PeopleAdolescent extends People {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adolescentId;

	@Column
	private List<MaterialAdolescent> adolescentMaterial;

	public PeopleAdolescent() {
		super();
	}

	public PeopleAdolescent(long peopleId, String nome, long idade, String dataNascimento) {
		super(peopleId, nome, idade, dataNascimento);
	}

	public PeopleAdolescent(long adolescentId, List<MaterialAdolescent> adolescentMaterial) {
		super();
		this.adolescentId = adolescentId;
		this.adolescentMaterial = adolescentMaterial;
	}

	public long getAdolescentId() {
		return adolescentId;
	}

	public void setAdolescentId(long adolescentId) {
		this.adolescentId = adolescentId;
	}

	public List<MaterialAdolescent> getAdolescentMaterial() {
		return adolescentMaterial;
	}

	public void setAdolescentMaterial(List<MaterialAdolescent> adolescentMaterial) {
		this.adolescentMaterial = adolescentMaterial;
	}

}
