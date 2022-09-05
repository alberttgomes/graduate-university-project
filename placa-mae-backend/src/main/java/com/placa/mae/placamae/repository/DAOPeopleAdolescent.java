package com.placa.mae.placamae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placa.mae.placamae.domain.PeopleAdolescent;

import java.util.Optional;

@Repository
public interface DAOPeopleAdolescent extends JpaRepository <PeopleAdolescent, Long>{
    Optional<PeopleAdolescent> findByEmail(String email);
    Optional<PeopleAdolescent> findByUsername(String username);
    Optional<PeopleAdolescent> findByUsernameOrEmail(String username, String email);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
}
