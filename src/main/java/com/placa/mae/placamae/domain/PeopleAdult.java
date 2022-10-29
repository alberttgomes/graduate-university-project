package com.placa.mae.placamae.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "adults", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"}),
		@UniqueConstraint(columnNames = {"username"})
})
public class PeopleAdult {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adultId;
	@Column(name = "age", length = 3, nullable = false)
	private int age;
	@Column(name = "email", length = 30, nullable = false)
	private String email;
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	@Column(name = "password", length = 15, nullable = false)
	private String password;
	@Column(name = "username", length = 15, nullable = false)
	private String username;

	public PeopleAdult(long adultId, int age, String email, String name, String password, String username, List<MaterialAdult> materialAdult) {
		this.adultId = adultId;
		this.age = age;
		this.email = email;
		this.name = name;
		this.password = password;
		this.username = username;
		this.materialAdult = materialAdult;
	}

	@OneToMany(targetEntity = MaterialAdult.class, fetch = FetchType.LAZY)
	@JoinColumn(name="fk_material_adult")
	private List<MaterialAdult> materialAdult = new ArrayList<>();

	public PeopleAdult() {
		super();
	}

	public long getAdultId() {
		return adultId;
	}

	public void setAdultId(long adultId) {
		this.adultId = adultId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<MaterialAdult> getMaterialAdult() {
		return materialAdult;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj instanceof PeopleAdult) {
			PeopleAdult other = (PeopleAdult) obj;
			return Objects.equals(name, other.name) && Objects.equals(age, other.age)
							&& Objects.equals(email, other.email) && Objects.equals(password, other.password)
							&& Objects.equals(materialAdult, other.materialAdult)
							&& Objects.equals(username, other.username);
		}
		return false;
	}
}
