package com.placa.mae.placamae.services;

import javax.persistence.EntityNotFoundException;

import com.placa.mae.placamae.domain.PeopleAdolescent;
import com.placa.mae.placamae.repository.DAOPeopleAdolescent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleAdolescentService {
 
        @Autowired
        private DAOPeopleAdolescent peopleAdolescentRepository;

        public PeopleAdolescent findById(Long id) {
             return peopleAdolescentRepository.findById(id).orElseThrow(
                 () -> new EntityNotFoundException("People id not found " + id)
             );
        }

}
