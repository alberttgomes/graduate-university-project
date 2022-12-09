package com.project.placa.mae.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.placa.mae.dto.SignUpDTO;
import com.project.placa.mae.dto.UpdateDTO;
import com.project.placa.mae.model.PeopleKid;
import com.project.placa.mae.repository.DAOPeopleKid;
import com.project.placa.mae.service.PeopleKidService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ControllerPeopleKid {
    @Autowired
    DAOPeopleKid daoPeopleKids;

    @Autowired
    PeopleKidService peopleKidService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "/kids")
    public List<PeopleKid> get() {
        return daoPeopleKids.findAll();
    }

    @GetMapping(value = "kids/{id}")
    public ResponseEntity<PeopleKid> findById(@PathVariable Long id){
        PeopleKid obj = peopleKidService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/kids")
    public ResponseEntity<SignUpDTO> create(@Validated @RequestBody SignUpDTO postDTO) throws Exception {
        //Convert DTO to Entity
        PeopleKid kidsSave = modelMapper.map(postDTO, PeopleKid.class);
        peopleKidService.createKids(kidsSave);

        //Convert Entity to DTO
        SignUpDTO kidsResponse = modelMapper.map(kidsSave, SignUpDTO.class);

        return new ResponseEntity<SignUpDTO>(kidsResponse, HttpStatus.CREATED);
    }

    @DeleteMapping( value = "/kids/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        daoPeopleKids.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/kids/{kidsId}")
    public ResponseEntity<UpdateDTO> update(@PathVariable Long id, @RequestBody UpdateDTO peopleDTO)
            throws Exception {

        //Convert DTO to Entity
        PeopleKid kidsRequest = modelMapper.map(peopleDTO, PeopleKid.class);
        PeopleKid kids = peopleKidService.updatKids(kidsRequest, id);

        //Convert Entity to DTO
        UpdateDTO adolescentResponse = modelMapper.map(kids, UpdateDTO.class);

        return ResponseEntity.ok().body(adolescentResponse);

    }
}
