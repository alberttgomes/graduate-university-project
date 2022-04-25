package com.placa.mae.placamae.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.placa.mae.placamae.entities.PeopleKids;
import com.placa.mae.placamae.repository.DAOPeopleKids;

@RestController
public class ControllerPeopleKids {

	@Autowired
	DAOPeopleKids daoPeopleKids;

	@RequestMapping(value = "/adolescent", method = RequestMethod.GET)
	public List<PeopleKids> Get() {
		return daoPeopleKids.findAll();
	}

	@RequestMapping(value = "/kids", method = RequestMethod.POST)
	public PeopleKids Post(@Validated @RequestBody PeopleKids kids) {
		return daoPeopleKids.save(kids);
	}

}
