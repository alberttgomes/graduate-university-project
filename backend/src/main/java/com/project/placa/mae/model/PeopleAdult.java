package com.project.placa.mae.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(targetEntity = ArticleAdult.class,mappedBy = "adultArticleId", fetch = FetchType.LAZY)
    private List<ArticleAdult> adultArticle = new ArrayList<>();
}
