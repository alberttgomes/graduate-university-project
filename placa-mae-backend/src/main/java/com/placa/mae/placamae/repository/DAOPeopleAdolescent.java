package com.placa.mae.placamae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placa.mae.placamae.domain.PeopleAdolescent;

@Repository
public interface DAOPeopleAdolescent extends JpaRepository <PeopleAdolescent, Long>{

}
