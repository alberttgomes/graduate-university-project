package com.project.placa.mae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.placa.mae.model.PeopleAdult;

@Repository
public interface DAOPeopleAdult extends JpaRepository<PeopleAdult, Long>{
    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<PeopleAdult> findByEmail(String email);

    Optional<PeopleAdult> findByUsername(String usernameOrEmail);

    Optional<PeopleAdult> findByUsernameOrEmail(String username, String email);
}
