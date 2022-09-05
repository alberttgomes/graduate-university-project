package com.placa.mae.placamae.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.placa.mae.placamae.services.PeopleAdultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.placa.mae.placamae.domain.PeopleAdolescent;
import com.placa.mae.placamae.repository.DAOPeopleAdolescent;
import com.placa.mae.placamae.services.PeopleAdolescentService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ControllerPeopleAdolescent {
	
	@Autowired
	DAOPeopleAdolescent daoPeopleAdolescent;

	@Autowired
	private PeopleAdolescentService peopleAdolescentService;

	public void PeopleAdolescentService (PeopleAdolescentService peopleAdolescentService) {

	}
	
	@RequestMapping(value = "/adolescents", method = RequestMethod.GET)
	public List<PeopleAdolescent> get(){
		return daoPeopleAdolescent.findAll();
	}

	@RequestMapping(value = "adolescents/{id}")
	public ResponseEntity<PeopleAdolescent> findById(@PathVariable Long id){
		PeopleAdolescent obj = peopleAdolescentService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/adolescents", method = RequestMethod.POST)
	public PeopleAdolescent post(@Validated @RequestBody PeopleAdolescent adolescent) {
		return daoPeopleAdolescent.save(adolescent);
	}
	
	@DeleteMapping(value="adolescents/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		daoPeopleAdolescent.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value="adolescents/{id}")
	public ResponseEntity<PeopleAdolescent> update(@PathVariable Long id, @RequestBody PeopleAdolescent obj){
		Optional<PeopleAdolescent> optionalObj  = daoPeopleAdolescent.findById(id);
		PeopleAdolescent peopleAdolescent = optionalObj.get();
		
		peopleAdolescent.setName(!Objects.isNull(obj.getName()) ? obj.getName() : peopleAdolescent.getName());
		peopleAdolescent.setAge(!Objects.isNull(obj.getAge()) ? obj.getAge() : peopleAdolescent.getAge());
		peopleAdolescent.setEmail(!Objects.isNull(obj.getEmail()) ? obj.getEmail() : peopleAdolescent.getEmail());
		peopleAdolescent.setPassword(!Objects.isNull(obj.getPassword()) ? obj.getPassword() : peopleAdolescent.getPassword());
		obj = daoPeopleAdolescent.save(peopleAdolescent);

		return ResponseEntity.ok().body(obj);
		
	}
}
