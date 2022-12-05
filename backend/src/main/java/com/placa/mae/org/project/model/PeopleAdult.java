package com.placa.mae.org.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "adults", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"}),
        @UniqueConstraint(columnNames = {"username"})
})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PeopleAdult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adultId;
    @Column(name = "age", length = 3)
    private int age;
    @Column(name = "date_register")
    private LocalDateTime dateRegister;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "username", length = 15)
    private String username;
    @Column(name = "score_quiz")
    private int scoreQuiz;

    @OneToMany(targetEntity = ArticleAdult.class, fetch = FetchType.LAZY)
    @JoinTable(name="fk_material_adult", joinColumns = @JoinColumn(name ="adultId", referencedColumnName = "adultId"))
    private List<ArticleAdult> adultMaterial = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof PeopleAdult) {
            PeopleAdult other = (PeopleAdult) obj;
            return	Objects.equals(age, other.age)
                    && Objects.equals(email, other.email) && Objects.equals(password, other.password)
                    && Objects.equals(adultMaterial, other.adultMaterial)
                    && Objects.equals(username, other.username);
        }
        return false;
    }

}
