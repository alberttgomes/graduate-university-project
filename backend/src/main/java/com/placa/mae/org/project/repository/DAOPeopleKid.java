package com.placa.mae.org.project.repository;

import com.placa.mae.org.project.model.PeopleKid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DAOPeopleKid extends JpaRepository<PeopleKid, Long> {

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<PeopleKid> findByEmail(String email);

    Optional<PeopleKid> findByUsername(String usernameOrEmail);

    Optional<PeopleKid> findByUsernameOrEmail(String username, String email);

}
