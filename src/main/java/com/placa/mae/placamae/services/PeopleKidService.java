package com.placa.mae.placamae.services;

import com.placa.mae.placamae.domain.PeopleAdolescent;
import com.placa.mae.placamae.domain.PeopleKids;
import com.placa.mae.placamae.repository.DAOPeopleAdolescent;
import com.placa.mae.placamae.repository.DAOPeopleKids;
import com.placa.mae.placamae.services.exceptions.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PeopleKidService implements UserDetailsService {
        @Autowired
        private DAOPeopleKids peopleKidRepository;

        public PeopleKidService(DAOPeopleKids peopleKidRepository) {
            this.peopleKidRepository = peopleKidRepository;
        }

        public PeopleKids findById(Long id) {
            return peopleKidRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("People id not found: " + id) );
        }

        @Override
        public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
            PeopleKids kids = peopleKidRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                    .orElseThrow(() ->
                            new UsernameNotFoundException(
                                    "user not found with username or email: " + usernameOrEmail));
            return new org.springframework.security.core.userdetails.User(kids.getEmail(),
                    kids.getPassword(), new ArrayList<>());
        }

}
