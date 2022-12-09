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
import com.project.placa.mae.model.PeopleKid;
import com.project.placa.mae.repository.DAOPeopleKid;

@Service
public class PeopleAdminService {
    @Autowired
    private DAOPeopleKid peopleKidRepository;

    public void PeopleKidService(DAOPeopleKid peopleKidRepository) {
        this.peopleKidRepository = peopleKidRepository;
    }

    // Create a new people category kids
    public PeopleKid createKids(PeopleKid kids) throws UsernameOrEmailAlreadyExists {
        boolean verifyExists = usernameVerify(kids.getUsername());

        // Check age equivalent
        if (kids.getAge() <= 13) {
            System.out.println("Age checked");
        }
        else {
            throw new InvalidAge("Age to category invalid exception");
        }

        if (!verifyExists) {
            throw new UsernameOrEmailAlreadyExists("Username already exists");
        }


        return peopleKidRepository.save(kids);
    }

    // Update existing people category kids
    public PeopleKid updatKids(PeopleKid kids, long id) throws Exception {
        Optional<PeopleKid> optionalObj = peopleKidRepository.findById(id);
        PeopleKid peopleKids = optionalObj.get();

        peopleKids.setAge(!Objects.isNull(kids.getAge()) ? kids.getAge() : peopleKids.getAge());
        peopleKids.setEmail(!Objects.isNull(kids.getEmail()) ? kids.getEmail() : peopleKids.getEmail());
        peopleKids.setPassword(!Objects.isNull(kids.getPassword()) ? kids.getPassword() : peopleKids.getPassword());
        peopleKids.setUsername(!Objects.isNull(kids.getUsername()) ? kids.getUsername() : peopleKids.getUsername());
        kids = peopleKidRepository.save(peopleKids);

        return ResponseEntity.ok().body(kids).getBody();

    }

    // Find people by id
    public PeopleKid findById(Long id) {
        return peopleKidRepository.findById(id).orElseThrow(
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

            return  peopleKidRepository.existsByUsername(username);

        } catch(Exception exception) {

            return false;
        }
    }
}
