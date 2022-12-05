package com.placa.mae.org.project.repository;

import com.placa.mae.org.project.model.PeopleAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DAOPeopleAdmin extends JpaRepository<PeopleAdmin, Long> {

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<PeopleAdmin> findByEmail(String email);

    Optional<PeopleAdmin> findByUsername(String usernameOrEmail);

    Optional<PeopleAdmin> findByUsernameOrEmail(String username, String email);

}
