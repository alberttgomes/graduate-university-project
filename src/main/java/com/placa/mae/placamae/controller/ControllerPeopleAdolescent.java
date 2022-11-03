package com.placa.mae.placamae.controller;

import com.placa.mae.placamae.domain.PeopleAdolescent;
import com.placa.mae.placamae.dto.AdolescentInsertDTO;
import com.placa.mae.placamae.dto.PeopleAdolescentDTO;
import com.placa.mae.placamae.repository.DAOPeopleAdolescent;
import com.placa.mae.placamae.services.PeopleAdolescentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
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
	@ResponseBody
	public ResponseEntity<PeopleAdolescentDTO> create(@Validated @RequestBody AdolescentInsertDTO postDto,
														UriComponentsBuilder uriBuilder) {
		PeopleAdolescent adolescentSave = modelMapper.map(postDto, PeopleAdolescent.class);
		peopleAdolescentService.createAdolescent(adolescentSave);
		URI uri = uriBuilder.path("adolescent/{id}").buildAndExpand(adolescentSave.getAdolescentId()).toUri();
		
		return ResponseEntity.created(uri).body(new PeopleAdolescentDTO(adolescentSave));
	}
	
	@DeleteMapping(value="adolescents/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		daoPeopleAdolescent.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value="adolescents/{id}")
	public ResponseEntity<PeopleAdolescent> update(@PathVariable Long id, @RequestBody PeopleAdolescent obj) {
		Optional<PeopleAdolescent> optionalObj  = daoPeopleAdolescent.findById(id);
		PeopleAdolescent peopleAdolescent = optionalObj.get();
		
		peopleAdolescent.setAge(!Objects.isNull(obj.getAge()) ? obj.getAge() : peopleAdolescent.getAge());
		peopleAdolescent.setEmail(!Objects.isNull(obj.getEmail()) ? obj.getEmail() : peopleAdolescent.getEmail());
		peopleAdolescent.setPassword(!Objects.isNull(obj.getPassword()) ? obj.getPassword() : peopleAdolescent.getPassword());
		obj = daoPeopleAdolescent.save(peopleAdolescent);

		return ResponseEntity.ok().body(obj);
		
	}
}
