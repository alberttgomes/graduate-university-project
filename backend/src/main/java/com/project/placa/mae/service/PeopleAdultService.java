package com.project.placa.mae.service;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.placa.mae.exception.InvalidAge;
import com.project.placa.mae.exception.UsernameNotFoundException;
import com.project.placa.mae.exception.UsernameOrEmailAlreadyExists;
import com.project.placa.mae.model.PeopleAdult;
import com.project.placa.mae.repository.DAOPeopleAdult;

@Service
public class PeopleAdultService {
    @Autowired
    private DAOPeopleAdult peopleAdultRepository;

    public PeopleAdultService (DAOPeopleAdult peopleAdultRepository) {
        this.peopleAdultRepository = peopleAdultRepository;
    }

    // Create a new people category adults
    public PeopleAdult createAdult(PeopleAdult adult) throws UsernameOrEmailAlreadyExists {

        boolean verifyExists = usernameVerify(adult.getUsername());

        // Check age equivalent
        if (adult.getAge() >= 17) {
            System.out.println("Age checked");
        }
        else {
            throw new InvalidAge("Age to category invalid exception");
        }

        if (verifyExists) {
            throw new UsernameOrEmailAlreadyExists(
                    "Username already exists");
        }

        return peopleAdultRepository.save(adult);

    }

    // Update existing people category adults
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
}
