package com.placa.mae.placamae.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.placa.mae.placamae.entities.PeopleAdult;
import com.placa.mae.placamae.repository.DAOPeopleAdult;

@RestController
public class ControllerPeopleAdult {

	@Autowired
	DAOPeopleAdult daoPeopleAdul;

	@RequestMapping(value = "/adult", method = RequestMethod.GET)
	public List<PeopleAdult> Get() {
		return daoPeopleAdul.findAll();
	}

	@RequestMapping(value = "/adult", method = RequestMethod.POST, produces = "application/json")
	public PeopleAdult Post(@Validated @RequestBody PeopleAdult adult) {
		return daoPeopleAdul.save(adult);
	}
}
