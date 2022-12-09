package com.project.placa.mae.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.project.placa.mae.dto.SignUpDTO;
import com.project.placa.mae.dto.UpdateDTO;
import com.project.placa.mae.model.PeopleAdolescent;
import com.project.placa.mae.service.PeopleAdolescentService;
import com.project.placa.mae.repository.DAOPeopleAdolescent;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
public class ControllerPeopleAdolescent {
    @Autowired
    private DAOPeopleAdolescent daoPeopleAdolescent;
    
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private PeopleAdolescentService peopleAdolescentService;

    public void PeopleAdolescentService (PeopleAdolescentService peopleAdolescentService) {
        this.peopleAdolescentService = peopleAdolescentService;
    }


    @GetMapping(value = "/adolescents")
    public List<PeopleAdolescent> get() {
        return daoPeopleAdolescent.findAll();
    }

    @GetMapping(value = "adolescents/{id}")
    public ResponseEntity<PeopleAdolescent> findById(@PathVariable Long id) throws Exception {
        PeopleAdolescent obj = peopleAdolescentService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/adolescents")
    public ResponseEntity<SignUpDTO> create(@Validated @RequestBody SignUpDTO postDto) throws Exception {
        //Convert DTO to entity
        PeopleAdolescent adolescentSave = modelMapper.map(postDto, PeopleAdolescent.class);
        peopleAdolescentService.createAdolescent(adolescentSave);

        //Convert entity to DTO
        SignUpDTO adolescentResponse = modelMapper.map(adolescentSave, SignUpDTO.class);

        return new ResponseEntity<SignUpDTO>(adolescentResponse, HttpStatus.CREATED);

    }

    @DeleteMapping(value="adolescents/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        daoPeopleAdolescent.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="adolescents/{id}")
    public ResponseEntity<UpdateDTO> update(@PathVariable Long id, @RequestBody UpdateDTO update) {
        //Convert DTO to Entity
        PeopleAdolescent adolescentRequest = modelMapper.map(update, PeopleAdolescent.class);
        PeopleAdolescent adolescent = peopleAdolescentService.updateAdolescent(id, adolescentRequest);

        //Convert Entity to DTO
        UpdateDTO adolescentResponse = modelMapper.map(adolescent, UpdateDTO.class);

        return ResponseEntity.ok().body(adolescentResponse);

    }
}
