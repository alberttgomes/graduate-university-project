package com.project.placa.mae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.placa.mae.model.PeopleTeacher;

@Repository
public interface DAOPeopleTeacher extends JpaRepository<PeopleTeacher, Long> {
    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<PeopleTeacher> findByEmail(String email);

    Optional<PeopleTeacher> findByUsername(String usernameOrEmail);

    Optional<PeopleTeacher> findByUsernameOrEmail(String username, String email);
}
