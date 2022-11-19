package com.placa.mae.placamae.services;

import java.util.Optional;
import com.placa.mae.placamae.domain.PeopleKids;
import com.placa.mae.placamae.repository.DAOPeopleKids;
import com.placa.mae.placamae.services.exceptions.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class PeopleKidService implements UserDetailsService {
        
        @Autowired
        private DAOPeopleKids peopleKidRepository;

        public PeopleKidService(DAOPeopleKids peopleKidRepository) {
            this.peopleKidRepository = peopleKidRepository;
        }

        // Create a new people category kids
        public PeopleKids createKids(PeopleKids kids) throws Exception {
             boolean verifyExists = usernameVerify(kids.getUsername());
             
             if (verifyExists) {
                 throw new UsernameNotFoundException("Username already exists");
             }

             kids.setPassword(new BCryptPasswordEncoder().encode(kids.getPassword()));

             return peopleKidRepository.save(kids);
        }
        
        //Update existing people category kids
        public PeopleKids updatKids(PeopleKids kids, long id) throws Exception {
             Optional<PeopleKids> optionalObj = peopleKidRepository.findById(id);
             PeopleKids peopleKids = optionalObj.get();

             peopleKids.setAge(!Objects.isNull(kids.getAge()) ? kids.getAge() : peopleKids.getAge());
             peopleKids.setEmail(!Objects.isNull(kids.getEmail()) ? kids.getEmail() : peopleKids.getEmail());
             peopleKids.setPassword(!Objects.isNull(kids.getPassword()) ? kids.getPassword() : peopleKids.getPassword());
             peopleKids.setUsername(!Objects.isNull(kids.getUsername()) ? kids.getUsername() : peopleKids.getUsername());
             kids = peopleKidRepository.save(peopleKids);    
         
             return ResponseEntity.ok().body(kids).getBody();

        }
        
        //Find people by id
        public PeopleKids findById(Long id) {
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
