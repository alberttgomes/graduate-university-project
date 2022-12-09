package com.project.placa.mae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.placa.mae.model.PeopleAdmin;

@Repository
public interface DAOPeopleAdmin extends JpaRepository<PeopleAdmin, Long>{
    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<PeopleAdmin> findByEmail(String email);

    Optional<PeopleAdmin> findByUsername(String usernameOrEmail);

    Optional<PeopleAdmin> findByUsernameOrEmail(String username, String email);
}
