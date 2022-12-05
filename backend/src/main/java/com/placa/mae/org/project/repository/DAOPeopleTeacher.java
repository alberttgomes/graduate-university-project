package com.placa.mae.org.project.repository;

import com.placa.mae.org.project.model.PeopleTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DAOPeopleTeacher extends JpaRepository<PeopleTeacher, Long> {

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<PeopleTeacher> findByEmail(String email);

    Optional<PeopleTeacher> findByUsername(String usernameOrEmail);

    Optional<PeopleTeacher> findByUsernameOrEmail(String username, String email);

}
