package com.placa.mae.placamae.services;

import javax.persistence.EntityNotFoundException;

import com.placa.mae.placamae.domain.PeopleAdult;
import com.placa.mae.placamae.repository.DAOPeopleAdult;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class PeopleAdultService implements UserDetailsService {
    
    @Autowired
    private DAOPeopleAdult peopleAdultRepository;

    public PeopleAdultService (DAOPeopleAdult peopleAdultRepository) {
        this.peopleAdultRepository = peopleAdultRepository;
    }

    public PeopleAdult findById(Long id) {
        return peopleAdultRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("People id not found: " + id) );
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        PeopleAdult adult = peopleAdultRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "user not found with username or email: " + usernameOrEmail));
        return new org.springframework.security.core.userdetails.User(adult.getEmail(),
                adult.getPassword(), new ArrayList<>());
    }

}
