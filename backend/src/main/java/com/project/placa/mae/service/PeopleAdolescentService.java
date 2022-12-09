package com.project.placa.mae.service;

import java.util.Objects;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.placa.mae.exception.InvalidAge;
import com.project.placa.mae.exception.UsernameNotFoundException;
import com.project.placa.mae.exception.UsernameOrEmailAlreadyExists;
import com.project.placa.mae.model.PeopleAdolescent;
import com.project.placa.mae.repository.DAOPeopleAdolescent;


@Service
public class PeopleAdolescentService {
    @Autowired
    private DAOPeopleAdolescent peopleAdolescentRepository;

    public PeopleAdolescentService(DAOPeopleAdolescent peopleAdolescentRepository) {
        this.peopleAdolescentRepository = peopleAdolescentRepository;
    }

    // Create a new people
    public PeopleAdolescent createAdolescent (PeopleAdolescent adolescent) throws UsernameOrEmailAlreadyExists {
        boolean verifyExists = usernameVerify(adolescent.getUsername());

        // Check age equivalent
        if (adolescent.getAge() > 13 && adolescent.getAge() <= 18) {
            System.out.println("Age checked");
        }
        else {
            throw new InvalidAge("Age to category invalid exception");
        }

        if (verifyExists) {
            throw new UsernameOrEmailAlreadyExists(
                    "Username already exists");
        }

        //adolescent.setPassword(new BCryptPasswordEncoder().encode(adolescent.getPassword()));

        return peopleAdolescentRepository.save(adolescent);

    }

    // Update existing people category adolescent
    public PeopleAdolescent updateAdolescent (long id, PeopleAdolescent adolescent) {
        java.util.Optional<PeopleAdolescent> optionalObj  = peopleAdolescentRepository.findById(id);
        PeopleAdolescent peopleAdolescent = optionalObj.get();

        peopleAdolescent.setUsername(!Objects.isNull(adolescent.getUsername()) ? adolescent.getUsername() : peopleAdolescent.getUsername());
        peopleAdolescent.setAge(!Objects.isNull(adolescent.getAge()) ? adolescent.getAge() : peopleAdolescent.getAge());
        peopleAdolescent.setEmail(!Objects.isNull(adolescent.getEmail()) ? adolescent.getEmail() : peopleAdolescent.getEmail());
        peopleAdolescent.setPassword(!Objects.isNull(adolescent.getPassword()) ? adolescent.getPassword() : peopleAdolescent.getPassword());
        adolescent = peopleAdolescentRepository.save(peopleAdolescent);

        return ResponseEntity.ok().body(adolescent).getBody();
    }

    // Verify already username
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

    // Found people by id
    public PeopleAdolescent findById(Long id) throws Exception {
        return peopleAdolescentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("People id not found " + id)
        );
    }
}
