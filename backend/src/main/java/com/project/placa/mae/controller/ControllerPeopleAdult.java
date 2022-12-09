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
import com.project.placa.mae.model.PeopleAdult;
import com.project.placa.mae.repository.DAOPeopleAdult;
import com.project.placa.mae.service.PeopleAdultService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ControllerPeopleAdult {
    @Autowired
    private PeopleAdultService adultService;
    
    private ModelMapper modelMapper = new ModelMapper();
   
    @Autowired
    private DAOPeopleAdult daoPeopleAdult;

    @GetMapping(value = "/adults")
    public List<PeopleAdult> get() {
        return daoPeopleAdult.findAll();
    }

    @GetMapping(value = "adults/{id}")
    public ResponseEntity<PeopleAdult> findById(@PathVariable Long id){
        PeopleAdult obj = adultService.findById(id);

        return ResponseEntity.ok().body(obj);

    }

    @DeleteMapping(value = "/adults/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        daoPeopleAdult.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @PostMapping(value = "/adults")
    public ResponseEntity<SignUpDTO> create(@Validated @RequestBody SignUpDTO postDto) throws Exception {
        //Convert DTO to entity
        PeopleAdult adolescentSave = modelMapper.map(postDto, PeopleAdult.class);
        adultService.createAdult(adolescentSave);

        //Convert entity to DTO
        SignUpDTO adolescentResponse = modelMapper.map(adolescentSave, SignUpDTO.class);

        return new ResponseEntity<SignUpDTO>(adolescentResponse, HttpStatus.CREATED);

    }

    @PutMapping(value="adult/{id}")
    public ResponseEntity<UpdateDTO> update(@PathVariable Long id, @RequestBody UpdateDTO peopleDTO) {
        //Convert DTO to Entity
        PeopleAdult adultRequest = modelMapper.map(peopleDTO, PeopleAdult.class);
        PeopleAdult adult = adultService.updateAdult(id, adultRequest);

        //Convert Entity to DTO
        UpdateDTO adolescentResponse = modelMapper.map(adult, UpdateDTO.class);

        return ResponseEntity.ok().body(adolescentResponse);

    }
}
