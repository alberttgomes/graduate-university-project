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
@Table(name = "kids", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"}),
		@UniqueConstraint(columnNames = {"username"})
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PeopleKids implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long kisId;
	@Column(name = "age", length = 3, nullable = false)
	private int age;
	@Column(name = "email", length = 30, nullable = false)
	private String email;
	@Column(name = "password", length = 15, nullable = false)
	private String password;
	@Column(name = "username", length = 15, nullable = false)
	private String username;
	@Column(name = "score_quiz")
	private int scoreQuiz;

	@OneToMany(targetEntity = MaterialKids.class, fetch = FetchType.LAZY)
	@JoinColumn(name="fk_material_kids")
	private List<MaterialKids> materialKids = new ArrayList<>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) this.materialKids;
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
		if(obj instanceof PeopleKids) {
			PeopleKids other = (PeopleKids) obj;
			return Objects.equals(age, other.age)
						&& Objects.equals(email, other.email) && Objects.equals(password, other.password)
						&& Objects.equals(materialKids, other.materialKids);
		}
		return false;
	}

}
