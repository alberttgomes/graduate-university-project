package com.placa.mae.placamae.services;

import javax.persistence.EntityNotFoundException;

import com.placa.mae.placamae.domain.MaterialAdolescent;
import com.placa.mae.placamae.domain.PeopleAdolescent;
import com.placa.mae.placamae.repository.DAOPeopleAdolescent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeopleAdolescentService implements UserDetailsService {
        @Autowired
        private DAOPeopleAdolescent peopleAdolescentRepository;

        public PeopleAdolescentService(DAOPeopleAdolescent peopleAdolescentRepository) {
            this.peopleAdolescentRepository = peopleAdolescentRepository;
        }

        public PeopleAdolescent findById(Long id) {
             return peopleAdolescentRepository.findById(id).orElseThrow(
                 () -> new EntityNotFoundException("People id not found " + id)
             );
        }

        public PeopleAdolescent createAdolescent (PeopleAdolescent adolescent) {
            boolean verifyExists = verifyPeopleExists(adolescent.getUsername());;

            if (!verifyExists) {
                adolescent.setPassword(new BCryptPasswordEncoder().encode(adolescent.getPassword()));
            }
            return peopleAdolescentRepository.save(adolescent);
        }

        public boolean verifyPeopleExists (String emailOrUsername) throws UsernameNotFoundException {
             if (emailOrUsername.equals("")) {
                 throw new UsernameNotFoundException(
                         "user not found with username or email: " + emailOrUsername);
             }
             try {
                 peopleAdolescentRepository.findByUsernameOrEmail
                         (emailOrUsername, emailOrUsername);

                 return true;
             } catch (Exception e) {
                 return false;
             }
        }

        @Override
        public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
            PeopleAdolescent adolescent = peopleAdolescentRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                    .orElseThrow(() ->
                            new UsernameNotFoundException(
                                    "user not found with username or email: " + usernameOrEmail));
            return new org.springframework.security.core.userdetails.User(adolescent.getEmail(),
                    adolescent.getPassword(), mapRolesToAuthorities(adolescent.getAdolescentMaterial()));
        }

        private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<MaterialAdolescent> adolescentMaterial) {
            return adolescentMaterial.stream().map(material ->
                    new SimpleGrantedAuthority(material.getTitle())).collect(Collectors.toList());
        }
}
