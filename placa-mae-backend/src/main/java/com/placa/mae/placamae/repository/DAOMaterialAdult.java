package com.placa.mae.placamae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placa.mae.placamae.entities.MaterialAdult;

@Repository
public interface DAOMaterialAdult extends JpaRepository<MaterialAdult, Long>{

}
