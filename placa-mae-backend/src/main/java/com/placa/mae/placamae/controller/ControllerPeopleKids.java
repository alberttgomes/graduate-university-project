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

import com.placa.mae.placamae.domain.PeopleKids;
import com.placa.mae.placamae.repository.DAOPeopleKids;
import com.placa.mae.placamae.services.PeopleKidService;

@RestController
public class ControllerPeopleKids {

	@Autowired
	DAOPeopleKids daoPeopleKids;

	@Autowired
	PeopleKidService daoPeopleKidService;

	@RequestMapping(value = "/kid", method = RequestMethod.GET)
	public List<PeopleKids> Get() {
		return daoPeopleKids.findAll();
	}

	@RequestMapping(value = "kid/{id}")
	public ResponseEntity<PeopleKids> findById(@PathVariable Long id){
		PeopleKids obj = daoPeopleKidService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/kid", method = RequestMethod.POST)
	public PeopleKids Post(@Validated @RequestBody PeopleKids kids) {
		return daoPeopleKids.save(kids);
	}

}
