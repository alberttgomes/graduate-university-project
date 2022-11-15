package com.placa.mae.placamae.services;

import javax.persistence.EntityNotFoundException;

import com.placa.mae.placamae.domain.MaterialAdolescent;
import com.placa.mae.placamae.domain.PeopleAdolescent;
import com.placa.mae.placamae.repository.DAOPeopleAdolescent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeopleAdolescentService implements UserDetailsService {
    @Autowired
    private DAOPeopleAdolescent peopleAdolescentRepository;

    public PeopleAdolescentService(DAOPeopleAdolescent peopleAdolescentRepository) {
        this.peopleAdolescentRepository = peopleAdolescentRepository;
    }

    // Found people by id 
    public PeopleAdolescent findById(Long id) {
         return peopleAdolescentRepository.findById(id).orElseThrow(
             () -> new EntityNotFoundException("People id not found " + id)
         );
    }

    // Create a new people 
    public PeopleAdolescent createAdolescent (PeopleAdolescent adolescent) {
        boolean verifyExists = usernameVerify(adolescent.getUsername());

        if (!verifyExists) {
            adolescent.setPassword(new BCryptPasswordEncoder().encode(adolescent.getPassword()));
        }

        return peopleAdolescentRepository.save(adolescent);
    }

    // Update an people existing
    public PeopleAdolescent updateAdolescent (long id, PeopleAdolescent adolescent) {
        Optional<PeopleAdolescent> optionalObj  = peopleAdolescentRepository.findById(id);
        PeopleAdolescent peopleAdolescent = optionalObj.get();

        peopleAdolescent.setUsername(!Objects.isNull(adolescent.getUsername()) ? adolescent.getUsername() : peopleAdolescent.getUsername());
        peopleAdolescent.setAge(!Objects.isNull(adolescent.getAge()) ? adolescent.getAge() : peopleAdolescent.getAge());
        peopleAdolescent.setEmail(!Objects.isNull(adolescent.getEmail()) ? adolescent.getEmail() : peopleAdolescent.getEmail());
        peopleAdolescent.setPassword(!Objects.isNull(adolescent.getPassword()) ? adolescent.getPassword() : peopleAdolescent.getPassword());
        adolescent = peopleAdolescentRepository.save(peopleAdolescent);

        return ResponseEntity.ok().body(adolescent).getBody();
    }

    public boolean usernameVerify (String username) 
        throws UsernameNotFoundException {
        
        if (username.isEmpty()) {
            throw new UsernameNotFoundException(
                  "The user name can't be empty: " + username);
        }

        try {
            
            return  peopleAdolescentRepository.existsByUsername(username);

        } catch(Exception exception) {

            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) 
        throws UsernameNotFoundException {
        
        PeopleAdolescent adolescent = peopleAdolescentRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException(
                                "user not found with username or email: " + usernameOrEmail));
        
        return new org.springframework.security.core.userdetails.User(adolescent.getEmail(),
                adolescent.getPassword(), mapRolesToAuthorities(adolescent.getAdolescentMaterial()));
    
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<MaterialAdolescent> collection) {
        return collection.stream().map(material ->
                new SimpleGrantedAuthority(material.getTitle())).collect(Collectors.toList());
    }

}
