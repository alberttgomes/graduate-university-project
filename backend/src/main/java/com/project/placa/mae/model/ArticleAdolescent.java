package com.project.placa.mae.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "articleAdolescents", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title"})
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticleAdolescent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adolescentArticleId;
    @Column(name = "title", length = 25, nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "date_article")
    private LocalDateTime dateArticle;
}
