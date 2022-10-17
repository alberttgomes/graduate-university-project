package com.placa.mae.placamae.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;


@Entity
@Table(name = "adolescents", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"}),
		@UniqueConstraint(columnNames = {"username"})
})
public class PeopleAdolescent implements UserDetails{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long adolescentId;
		@Column(name = "age", length = 3, nullable = false)
		private int age;
		@Column(name = "date_register")
		private LocalDateTime dateRegister;
		@Column(name = "email", length = 30, nullable = false)
		private String email;
		@Column(name = "name", length = 20, nullable = false)
		private String name;
		@Column(name = "password", length = 15, nullable = false)
		private String password;
		@Column(name = "username", length = 15, nullable = false)
		private String username;

		@OneToMany(targetEntity = MaterialAdolescent.class, fetch = FetchType.LAZY)
		@JoinTable(name="fk_material_adolescent", joinColumns = @JoinColumn(name ="adolescentId", referencedColumnName = "adolescentId"))
		private Collection<MaterialAdolescent> adolescentMaterial = new ArrayList<>();

		public PeopleAdolescent() {
			super();
		}

		public PeopleAdolescent(long adolescentId, int age, LocalDateTime dateRegister, String email, String name, String password, String username, List<MaterialAdolescent> adolescentMaterial) {
			super();
			this.adolescentId = adolescentId;
			this.age = age;
			this.dateRegister = dateRegister;
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

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public LocalDateTime getDateRegister() {
			return dateRegister;
		}

		public void setDateRegister(LocalDateTime dateRegister) {
			this.dateRegister = dateRegister;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public Collection<MaterialAdolescent> getAdolescentMaterial() {
			return adolescentMaterial;
		}

		public void setAdolescentMaterial(List<MaterialAdolescent> adolescentMaterial) {
			this.adolescentMaterial = adolescentMaterial;
		}

		@Override
		public boolean isAccountNonExpired() {
			return false;
		}

		@Override
		public boolean isAccountNonLocked() {
			return false;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return false;
		}

		@Override
		public boolean isEnabled() {
			return false;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return (Collection<? extends GrantedAuthority>) this.adolescentMaterial;
		}

		@Override
		public String toString() {
			return "PeopleAdolescent{" +
					"adolescentId=" + adolescentId +
					'}';
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
