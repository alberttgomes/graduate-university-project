package com.placa.mae.placamae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placa.mae.placamae.entities.MaterialAdolescent;

@Repository
public interface DAOMaterialAdolescent extends JpaRepository <MaterialAdolescent, Long>{

}
