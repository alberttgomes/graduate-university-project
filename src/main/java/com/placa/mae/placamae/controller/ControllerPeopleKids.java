package com.placa.mae.placamae.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.placa.mae.placamae.domain.PeopleKids;
import com.placa.mae.placamae.dto.AdolescentDTO;
import com.placa.mae.placamae.repository.DAOPeopleKids;
import com.placa.mae.placamae.services.PeopleKidService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ControllerPeopleKids {

	@Autowired
	DAOPeopleKids daoPeopleKids;

	@Autowired
	PeopleKidService peopleKidService;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(value = "/kids")
	public List<PeopleKids> get() {
		return daoPeopleKids.findAll();
	}

	@GetMapping(value = "kids/{id}")
	public ResponseEntity<PeopleKids> findById(@PathVariable Long id){
		PeopleKids obj = peopleKidService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(value = "/kids")
	public ResponseEntity<AdolescentDTO> create(@Validated @RequestBody AdolescentDTO postDTO) throws Exception {
		//Convert DTO to Entity
		PeopleKids kidsSave = modelMapper.map(postDTO, PeopleKids.class);
		peopleKidService.createKids(kidsSave);

		//Convert Entity to DTO
		AdolescentDTO kidsResponse = modelMapper.map(kidsSave, AdolescentDTO.class);
		
		return new ResponseEntity<AdolescentDTO>(kidsResponse, HttpStatus.CREATED);
	}

	@DeleteMapping( value = "/kids/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id){
		daoPeopleKids.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/kids/{kidsId}")
	public ResponseEntity<AdolescentDTO> update(@PathVariable Long id, @RequestBody AdolescentDTO adolescentDTO) 
		throws Exception {
		
		//Convert DTO to Entity
		PeopleKids kidsRequest = modelMapper.map(adolescentDTO, PeopleKids.class);
		PeopleKids kids = peopleKidService.updatKids(kidsRequest, id);
		
		//Convert Entity to DTO
		AdolescentDTO adolescentResponse = modelMapper.map(kids, AdolescentDTO.class);
		
		return ResponseEntity.ok().body(adolescentResponse);

    }

}	
