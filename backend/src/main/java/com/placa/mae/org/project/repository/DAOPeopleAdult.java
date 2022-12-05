package com.placa.mae.org.project.repository;

import com.placa.mae.org.project.model.PeopleAdult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DAOPeopleAdult extends JpaRepository<PeopleAdult, Long> {

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<PeopleAdult> findByEmail(String email);

    Optional<PeopleAdult> findByUsername(String usernameOrEmail);

    Optional<PeopleAdult> findByUsernameOrEmail(String username, String email);

}
