package com.placa.mae.placamae.controller;

import com.placa.mae.placamae.domain.PeopleAdolescent;
import com.placa.mae.placamae.dto.AdolescentDTO;
import com.placa.mae.placamae.repository.DAOPeopleAdolescent;
import com.placa.mae.placamae.services.PeopleAdolescentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ControllerPeopleAdolescent {
	@Autowired
	DAOPeopleAdolescent daoPeopleAdolescent;

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
	public ResponseEntity<PeopleAdolescent> findById(@PathVariable Long id) {
		PeopleAdolescent obj = peopleAdolescentService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "/adolescents")
	public ResponseEntity<AdolescentDTO> create(@Validated @RequestBody AdolescentDTO postDto) {
		//Convert DTO to entity
		PeopleAdolescent adolescentSave = modelMapper.map(postDto, PeopleAdolescent.class);
		peopleAdolescentService.createAdolescent(adolescentSave);
		//Convert entity to DTO
		AdolescentDTO adolescentResponse = modelMapper.map(adolescentSave, AdolescentDTO.class);

		return new ResponseEntity<AdolescentDTO>(adolescentResponse, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="adolescents/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		daoPeopleAdolescent.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value="adolescents/{id}")
	public ResponseEntity<AdolescentDTO> update(@PathVariable Long id, @RequestBody AdolescentDTO adolescentDTO) {
		//Convert DTO to Entity
		PeopleAdolescent adolescentRequest = modelMapper.map(adolescentDTO, PeopleAdolescent.class);
		PeopleAdolescent adolescent = peopleAdolescentService.updateAdolescent(id, adolescentRequest);

		//Entity to DTO
		AdolescentDTO adolescentResponse = modelMapper.map(adolescent, AdolescentDTO.class);

		return ResponseEntity.ok().body(adolescentResponse);
		
	}

}
