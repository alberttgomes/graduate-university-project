package com.project.placa.mae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.placa.mae.model.ArticleAdolescent;

@Repository
public interface DAOArticleAdolescent extends JpaRepository <ArticleAdolescent, Long> {
        
}
