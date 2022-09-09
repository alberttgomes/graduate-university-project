package com.placa.mae.placamae.repository;

import com.placa.mae.placamae.domain.PeopleAdolescent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placa.mae.placamae.domain.PeopleKids;

import java.util.Optional;

@Repository
public interface DAOPeopleKids extends JpaRepository <PeopleKids, Long> {
    Optional<PeopleKids> findByEmail(String email);
    Optional<PeopleKids> findByUsername(String username);
    Optional<PeopleKids> findByUsernameOrEmail(String username, String email);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
}
