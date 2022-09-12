package com.placa.mae.placamae.security;

import com.placa.mae.placamae.domain.PeopleAdolescent;
import com.placa.mae.placamae.repository.DAOPeopleAdolescent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private DAOPeopleAdolescent daoPeopleAdolescent;

    /*
     *Method to receiver data of users for authentication
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<PeopleAdolescent> adolescent = daoPeopleAdolescent.findByUsername(username);

        if (adolescent.isPresent()) {
            System.out.println("Try authenticated the user " + adolescent.get().getUsername());

            return  adolescent.get();
        }

        throw  new UsernameNotFoundException("Data invalid");
    }

}
