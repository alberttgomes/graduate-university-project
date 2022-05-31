package com.placa.mae.placamae.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class PeopleKids {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long kisId;
	private String name;
	private int age;
	
	@OneToMany(targetEntity = MaterialKids.class, fetch = FetchType.LAZY)
	@JoinColumn(name="fk_material_kids")
	private List<MaterialKids> materialKids = new ArrayList<>();

	public PeopleKids() {
		super();
	}

	public PeopleKids(long kisId, String name, int age) {
		this.kisId = kisId;
		this.name = name;
		this.age = age;
	}

	public long getKisId() {
		return kisId;
	}

	public void setKisId(long kisId) {
		this.kisId = kisId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
