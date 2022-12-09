package com.project.placa.mae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.placa.mae.model.PeopleAdolescent;

import java.util.Optional;

@Repository
public interface DAOPeopleAdolescent extends JpaRepository<PeopleAdolescent, Long> {
    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<PeopleAdolescent> findByEmail(String email);

    Optional<PeopleAdolescent> findByUsername(String usernameOrEmail);

    Optional<PeopleAdolescent> findByUsernameOrEmail(String username, String email);
}
