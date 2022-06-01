package com.placa.mae.placamae.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
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
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	@Column(name = "age", length = 3, nullable = false)
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


	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj instanceof PeopleAdult) {
			PeopleAdult other = (PeopleAdult) obj;
			return Objects.equals(name, other.name) && Objects.equals(age, other.age)
							&& Objects.equals(materialAdult, other.materialAdult);
		}
		return false;
	}
}
