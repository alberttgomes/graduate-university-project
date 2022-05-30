package com.placa.mae.placamae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placa.mae.placamae.domain.PeopleAdult;

@Repository
public interface DAOPeopleAdult extends JpaRepository <PeopleAdult, Long>{

}
