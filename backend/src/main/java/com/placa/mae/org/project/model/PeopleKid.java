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
@Table(name = "kids", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"}),
        @UniqueConstraint(columnNames = {"username"})
})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PeopleKid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long kidId;
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

    @OneToMany(targetEntity = ArticleKid.class, fetch = FetchType.LAZY)
    @JoinTable(name="fk_material_kid", joinColumns = @JoinColumn(name ="kidId", referencedColumnName = "kidId"))
    private List<ArticleKid> adolescentMaterial = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof PeopleKid) {
            PeopleKid other = (PeopleKid) obj;
            return	Objects.equals(age, other.age)
                    && Objects.equals(email, other.email) && Objects.equals(password, other.password)
                    && Objects.equals(adolescentMaterial, other.adolescentMaterial)
                    && Objects.equals(username, other.username);
        }
        return false;
    }

}
