package com.placa.mae.placamae.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "adults", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"}),
		@UniqueConstraint(columnNames = {"username"})
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PeopleAdult implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adultId;
	@Column(name = "age", length = 3)
	private int age;
	@Column(name = "email", length = 50)
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "username", length = 15)
	private String username;
	@Column(name = "score_quiz")
	private int scoreQuiz;

	@OneToMany(targetEntity = MaterialAdult.class, fetch = FetchType.LAZY)
	@JoinColumn(name="fk_material_adult")
	private List<MaterialAdult> materialAdult = new ArrayList<>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) this.materialAdult;
	}

	@Override
	public String getPassword() {
		return password;
	}


	@Override
	public String getUsername() {
		
		return username;
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
		if(!username.isEmpty()){
			return true;
		}

		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj instanceof PeopleAdult) {
			PeopleAdult other = (PeopleAdult) obj;
			return  Objects.equals(age, other.age)
							&& Objects.equals(email, other.email) && Objects.equals(password, other.password)
							&& Objects.equals(materialAdult, other.materialAdult)
							&& Objects.equals(username, other.username);
		}
		return false;
	}


}
