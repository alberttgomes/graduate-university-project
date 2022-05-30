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

import com.placa.mae.placamae.domain.PeopleAdult;
import com.placa.mae.placamae.repository.DAOPeopleAdult;
import com.placa.mae.placamae.services.PeopleService;

@RestController
public class ControllerPeopleAdult {

	@Autowired
	private PeopleService peopleService;

	@Autowired
	DAOPeopleAdult daoPeopleAdult;

	@RequestMapping(value = "/adult", method = RequestMethod.GET)
	public List<PeopleAdult> Get() {
		return daoPeopleAdult.findAll();
	}

	@RequestMapping(value = "adult/{id}")
	public ResponseEntity<PeopleAdult> findById(@PathVariable Long id){
		PeopleAdult obj = peopleService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/adult", method = RequestMethod.POST, produces = "application/json")
	public PeopleAdult Post(@Validated @RequestBody PeopleAdult adult) {
		return daoPeopleAdult.save(adult);
	}

}
