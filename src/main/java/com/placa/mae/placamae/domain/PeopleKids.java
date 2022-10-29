package com.placa.mae.placamae.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "kids", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"}),
		@UniqueConstraint(columnNames = {"username"})
})
public class PeopleKids {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long kisId;
	
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "age", length = 3, nullable = false)
	private int age;
	
	@Column(name = "email", length = 30, nullable = false)
	private String email;
	
	@Column(name = "password", length = 15, nullable = false)
	private String password;

	@Column(name = "username", length = 15, nullable = false)
	private String username;
	
	@OneToMany(targetEntity = MaterialKids.class, fetch = FetchType.LAZY)
	@JoinColumn(name="fk_material_kids")
	private List<MaterialKids> materialKids = new ArrayList<>();

	public PeopleKids() {
		super();
	}

	public PeopleKids(long kisId, String name, int age, String email, String password, String username) {
		super();
		this.age = age;
		this.email = email;
		this.kisId = kisId;
		this.name = name;
		this.password = password;
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<MaterialKids> getMaterialKids() {
		return materialKids;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj instanceof PeopleKids) {
			PeopleKids other = (PeopleKids) obj;
			return Objects.equals(name, other.name) && Objects.equals(age, other.age)
							&& Objects.equals(email, other.email) && Objects.equals(password, other.password)
							&& Objects.equals(materialKids, other.materialKids);
		}
		return false;
	}
}
