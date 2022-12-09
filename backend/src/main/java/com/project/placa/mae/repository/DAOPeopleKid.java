package com.project.placa.mae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.placa.mae.model.PeopleKid;

@Repository
public interface DAOPeopleKid extends JpaRepository<PeopleKid, Long> {
    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<PeopleKid> findByEmail(String email);

    Optional<PeopleKid> findByUsername(String usernameOrEmail);

    Optional<PeopleKid> findByUsernameOrEmail(String username, String email);
}
