package com.placa.mae.placamae.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.placa.mae.placamae.domain.PeopleKids;
import com.placa.mae.placamae.dto.PeopleDTO;
import com.placa.mae.placamae.repository.DAOPeopleKids;
import com.placa.mae.placamae.services.PeopleKidService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
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
	public ResponseEntity<PeopleDTO> create(@Validated @RequestBody PeopleDTO postDTO) throws Exception {
		//Convert DTO to Entity
		PeopleKids kidsSave = modelMapper.map(postDTO, PeopleKids.class);
		peopleKidService.createKids(kidsSave);

		//Convert Entity to DTO
		PeopleDTO kidsResponse = modelMapper.map(kidsSave, PeopleDTO.class);
		
		return new ResponseEntity<PeopleDTO>(kidsResponse, HttpStatus.CREATED);
	}

	@DeleteMapping( value = "/kids/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id){
		daoPeopleKids.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/kids/{kidsId}")
	public ResponseEntity<PeopleDTO> update(@PathVariable Long id, @RequestBody PeopleDTO peopleDTO)
		throws Exception {
		
		//Convert DTO to Entity
		PeopleKids kidsRequest = modelMapper.map(peopleDTO, PeopleKids.class);
		PeopleKids kids = peopleKidService.updatKids(kidsRequest, id);
		
		//Convert Entity to DTO
		PeopleDTO adolescentResponse = modelMapper.map(kids, PeopleDTO.class);
		
		return ResponseEntity.ok().body(adolescentResponse);

    }

}	
