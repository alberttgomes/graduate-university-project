package com.placa.mae.placamae.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.placa.mae.placamae.domain.PeopleAdult;
import com.placa.mae.placamae.dto.AdolescentDTO;
import com.placa.mae.placamae.repository.DAOPeopleAdult;
import com.placa.mae.placamae.services.PeopleAdultService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ControllerPeopleAdult {

	@Autowired
	private PeopleAdultService peopleAdultService;

	@Autowired
	DAOPeopleAdult daoPeopleAdult;

	@Autowired
	private ModelMapper modelMapper;
	
	@RequestMapping(value = "/adults", method = RequestMethod.GET)
	public List<PeopleAdult> get() {
		return daoPeopleAdult.findAll();
	}

	@RequestMapping(value = "adults/{id}")
	public ResponseEntity<PeopleAdult> findById(@PathVariable Long id){
		PeopleAdult obj = peopleAdultService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	
	}

	@DeleteMapping(value = "/adults/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id){
		daoPeopleAdult.deleteById(id);
		
		return ResponseEntity.noContent().build();
	
	}

	@PostMapping(value = "/adults")
	public ResponseEntity<AdolescentDTO> create(@Validated @RequestBody AdolescentDTO postDto) throws Exception {
		//Convert DTO to entity
		PeopleAdult adolescentSave = modelMapper.map(postDto, PeopleAdult.class);
		peopleAdultService.createAdult(adolescentSave);
		
		//Convert entity to DTO
		AdolescentDTO adolescentResponse = modelMapper.map(adolescentSave, AdolescentDTO.class);

		return new ResponseEntity<AdolescentDTO>(adolescentResponse, HttpStatus.CREATED);

	}

	@PutMapping(value="adult/{id}")
	public ResponseEntity<AdolescentDTO> update(@PathVariable Long id, @RequestBody AdolescentDTO adolescentDTO) {
		//Convert DTO to Entity
		PeopleAdult adultRequest = modelMapper.map(adolescentDTO, PeopleAdult.class);
		PeopleAdult adult = peopleAdultService.updateAdult(id, adultRequest);

		//Convert Entity to DTO
		AdolescentDTO adolescentResponse = modelMapper.map(adult, AdolescentDTO.class);

		return ResponseEntity.ok().body(adolescentResponse);
		
	}	

}
