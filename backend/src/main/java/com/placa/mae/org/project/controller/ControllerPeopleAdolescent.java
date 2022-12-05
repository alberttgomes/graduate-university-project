package com.placa.mae.org.project.controller;

import com.placa.mae.org.project.dto.SignUpDTO;
import com.placa.mae.org.project.model.PeopleAdolescent;
import com.placa.mae.org.project.repository.DAOPeopleAdolescent;
import com.placa.mae.org.project.service.PeopleAdolescentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
public class ControllerPeopleAdolescent {
    @Autowired
    private DAOPeopleAdolescent daoPeopleAdolescent;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PeopleAdolescentService peopleAdolescentService;

    public void PeopleAdolescentService (PeopleAdolescentService peopleAdolescentService) {
        this.peopleAdolescentService = peopleAdolescentService;
    }

    @RequestMapping(value = "/adolescents", method = RequestMethod.GET)
    public List<PeopleAdolescent> get() {
        return daoPeopleAdolescent.findAll();
    }

    @RequestMapping(value = "adolescents/{id}")
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
    public ResponseEntity<SignUpDTO> update(@PathVariable Long id, @RequestBody SignUpDTO peopleDTO) {
        //Convert DTO to Entity
        PeopleAdolescent adolescentRequest = modelMapper.map(peopleDTO, PeopleAdolescent.class);
        PeopleAdolescent adolescent = peopleAdolescentService.updateAdolescent(id, adolescentRequest);

        //Convert Entity to DTO
        SignUpDTO adolescentResponse = modelMapper.map(adolescent, SignUpDTO.class);

        return ResponseEntity.ok().body(adolescentResponse);

    }
}
