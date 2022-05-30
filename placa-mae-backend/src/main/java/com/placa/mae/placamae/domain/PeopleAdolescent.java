package com.placa.mae.placamae.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PeopleAdolescent {

			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			private long adolescentId;
			private String name;
			private int age;

		//	@OneToMany(targetEntity = MaterialAdolescent.class, fetch = FetchType.LAZY)
		//	@JoinColumn(name="fk_material_adolescent")
		//	private List<MaterialAdolescent> adolescentMaterial = new ArrayList<>();

			public PeopleAdolescent() {
				super();
			}

			public PeopleAdolescent(long adolescentId, String name, int age) {
				super();
				this.adolescentId = adolescentId;
				this.name = name;
				this.age = age;
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

}
