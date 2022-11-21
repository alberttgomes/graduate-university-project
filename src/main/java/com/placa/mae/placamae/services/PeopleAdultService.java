package com.placa.mae.placamae.services;

import javax.persistence.EntityNotFoundException;

import com.placa.mae.placamae.domain.PeopleAdult;
import com.placa.mae.placamae.repository.DAOPeopleAdult;
import com.placa.mae.placamae.services.exceptions.AgeInvalid;
import com.placa.mae.placamae.services.exceptions.UsernameOrEmailAlreadyExists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;


@Service
public class PeopleAdultService implements UserDetailsService {
    
    @Autowired
    private DAOPeopleAdult peopleAdultRepository;

    public PeopleAdultService (DAOPeopleAdult peopleAdultRepository) {
        this.peopleAdultRepository = peopleAdultRepository;
    }
    
    // Create a new people category kids
    public PeopleAdult createAdult(PeopleAdult adult) throws UsernameOrEmailAlreadyExists {
        boolean verifyExists = usernameVerify(adult.getUsername());
        
        // Check age equivalent
        if (adult.getAge() > 17) {
            System.out.println("Age checked");
        }
        else {
            throw new AgeInvalid("Age to category invalid exception");
        }
        
        if (verifyExists) {
            throw new UsernameOrEmailAlreadyExists(
                                "Username already exists");
        }

        if (!verifyExists) {
            throw new UsernameOrEmailAlreadyExists("Username already exists");
        }

        adult.setPassword(new BCryptPasswordEncoder().encode(adult.getPassword()));

        return peopleAdultRepository.save(adult);

    }
    
    // Update existing people category kids
    public PeopleAdult updateAdult(Long id, PeopleAdult adultRequest) {
        
        Optional<PeopleAdult> optionalObj  = peopleAdultRepository.findById(id);
        PeopleAdult peopleAdult = optionalObj.get();
        
        peopleAdult.setUsername(!Objects.isNull(adultRequest.getUsername()) ? adultRequest.getUsername() : peopleAdult.getUsername());
        peopleAdult.setAge(!Objects.isNull(adultRequest.getAge()) ? adultRequest.getAge() : peopleAdult.getAge());
        peopleAdult.setEmail(!Objects.isNull(adultRequest.getEmail()) ? adultRequest.getEmail() : peopleAdult.getEmail());
        peopleAdult.setPassword(!Objects.isNull(adultRequest.getPassword()) ? adultRequest.getPassword() : peopleAdult.getPassword());
        adultRequest = peopleAdultRepository.save(peopleAdult);

        return ResponseEntity.ok().body(adultRequest).getBody();

    }

    public PeopleAdult findById(Long id) {
        return peopleAdultRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("People id not found: " + id) );
    }

    // Verify username already exists
    public boolean usernameVerify (String username) 
        throws UsernameNotFoundException {

        if (username.isEmpty()) {
            throw new UsernameNotFoundException(
                    "The user name can't be empty: " + username);
        }

        try {
        
        return  peopleAdultRepository.existsByUsername(username);

        } catch(Exception exception) {

        return false;
        }
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
