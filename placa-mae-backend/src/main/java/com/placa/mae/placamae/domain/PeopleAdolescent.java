package com.placa.mae.placamae.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;


@Entity
@Table(name = "adolescents", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"}),
		@UniqueConstraint(columnNames = {"username"})
})
public class PeopleAdolescent {
			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			private long adolescentId;
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

			@OneToMany(targetEntity = MaterialAdolescent.class, fetch = FetchType.LAZY)
			@JoinColumn(name="fk_material_adolescent")
			private List<MaterialAdolescent> adolescentMaterial = new ArrayList<>();

			public PeopleAdolescent() {
				super();
			}

			public PeopleAdolescent(long adolescentId, int age, String email, String name, String password, String username, List<MaterialAdolescent> adolescentMaterial) {
				super();
				this.adolescentId = adolescentId;
				this.age = age;
				this.email = email;
				this.name = name;
				this.password = password;
				this.username = username;
				this.adolescentMaterial = adolescentMaterial;
			}

			public long getAdolescentId() {
				return adolescentId;
			}

			public void setAdolescentId(long adolescentId) {
				this.adolescentId = adolescentId;
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

			public List<MaterialAdolescent> getAdolescentMaterial() {
				return adolescentMaterial;
			}

			@Override
			public boolean equals(Object obj) {
				if(this == obj){
					return true;
				}
				if(obj instanceof PeopleAdolescent) {
					PeopleAdolescent other = (PeopleAdolescent) obj;
					return Objects.equals(name, other.name) && Objects.equals(age, other.age)
									&& Objects.equals(email, other.email) && Objects.equals(password, other.password)
									&& Objects.equals(adolescentMaterial, other.adolescentMaterial)
									&& Objects.equals(username, other.username);
				}
				return false;
			}

}
