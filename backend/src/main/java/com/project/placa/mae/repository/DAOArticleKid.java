package com.project.placa.mae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.placa.mae.model.ArticleKid;
import com.project.placa.mae.model.PeopleAdmin;

@Repository
public interface DAOArticleKid extends JpaRepository<ArticleKid, Long> {
    void postArticleKid(PeopleAdmin isAdmin, ArticleKid article);
}
