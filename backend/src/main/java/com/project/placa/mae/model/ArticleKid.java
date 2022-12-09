package com.project.placa.mae.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
@Table(name = "adults", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"}),
        @UniqueConstraint(columnNames = {"username"})
})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArticleKid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long kidArticleId;
    @Column(name = "title", length = 25, nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "date_article")
    private LocalDateTime dateArticle;
}
