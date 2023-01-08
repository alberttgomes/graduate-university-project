package com.project.placa.mae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.placa.mae.model.ArticleAdult;

@Repository
public interface DAOArticleAdult extends JpaRepository<ArticleAdult, Long>{

}
