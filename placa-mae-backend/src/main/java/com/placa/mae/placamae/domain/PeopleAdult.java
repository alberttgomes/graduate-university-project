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
public class PeopleAdult {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adultId;
	private String name;
	private int age;
	
	@OneToMany(targetEntity = MaterialAdult.class, fetch = FetchType.LAZY)
	@JoinColumn(name="fk_material_adult")
	private List<MaterialAdult> materialAdult = new ArrayList<>();

	public PeopleAdult() {
		super();
	}

	public PeopleAdult(long adultId, String name, int age) {
		super();
		this.adultId = adultId;
		this.name = name;
		this.age = age;
	}

	public long getAdultId() {
		return adultId;
	}

	public void setAdultId(long adultId) {
		this.adultId = adultId;
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
