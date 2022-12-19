package com.project.placa.mae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.placa.mae.model.ArticleAdolescent;
import com.project.placa.mae.model.PeopleAdmin;

@Repository
public interface DAOArticleAdolescent extends JpaRepository <ArticleAdolescent, Long> {
        
    Optional<ArticleAdolescent> postArticleAdolescent(PeopleAdmin isAdmin, ArticleAdolescent article);

}
