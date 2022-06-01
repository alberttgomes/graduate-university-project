package com.placa.mae.placamae.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.placa.mae.placamae.domain.PeopleAdolescent;
import com.placa.mae.placamae.repository.DAOPeopleAdolescent;
import com.placa.mae.placamae.services.PeopleAdolescentService;

@RestController
public class ControllerPeopleAdolescent {
	
	@Autowired
	DAOPeopleAdolescent daoPeopleAdolescent;

	@Autowired
	private PeopleAdolescentService peopleAdolescentService;
	
	@RequestMapping(value = "/adolescent", method = RequestMethod.GET)
	public List<PeopleAdolescent> Get(){
		return daoPeopleAdolescent.findAll();
	}

	@RequestMapping(value = "adolescent/{id}")
	public ResponseEntity<PeopleAdolescent> findById(@PathVariable Long id){
		PeopleAdolescent obj = peopleAdolescentService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/adolescent", method = RequestMethod.POST)
	public PeopleAdolescent Post(@Validated @RequestBody PeopleAdolescent adolescent) {
		return daoPeopleAdolescent.save(adolescent);
	}
	
}
