package com.placa.mae.placamae.services;

import com.placa.mae.placamae.domain.PeopleKids;
import com.placa.mae.placamae.repository.DAOPeopleKids;
import com.placa.mae.placamae.services.exceptions.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleKidService {
    
    
        @Autowired
        private DAOPeopleKids peopleKidRepository;

        public PeopleKids findById(Long id) {
            return peopleKidRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("People id not found: " + id) );
        }

}
