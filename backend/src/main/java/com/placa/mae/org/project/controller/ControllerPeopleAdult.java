package com.placa.mae.org.project.controller;

import com.placa.mae.org.project.dto.SignUpDTO;
import com.placa.mae.org.project.dto.UpdateDTO;
import com.placa.mae.org.project.model.PeopleAdult;
import com.placa.mae.org.project.repository.DAOPeopleAdult;
import com.placa.mae.org.project.service.PeopleAdultService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ControllerPeopleAdult {
    @Autowired
    private PeopleAdultService adultService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DAOPeopleAdult daoPeopleAdult;

    @RequestMapping(value = "/adults", method = RequestMethod.GET)
    public List<PeopleAdult> get() {
        return daoPeopleAdult.findAll();
    }

    @RequestMapping(value = "adults/{id}")
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
