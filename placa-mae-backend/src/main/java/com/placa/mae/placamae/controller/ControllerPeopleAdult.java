package com.placa.mae.placamae.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.placa.mae.placamae.domain.PeopleAdult;
import com.placa.mae.placamae.repository.DAOPeopleAdult;
import com.placa.mae.placamae.services.PeopleAdultService;

@RestController
public class ControllerPeopleAdult {

	@Autowired
	private PeopleAdultService peopleAdultService;

	@Autowired
	DAOPeopleAdult daoPeopleAdult;

	@RequestMapping(value = "/adult", method = RequestMethod.GET)
	public List<PeopleAdult> Get() {
		return daoPeopleAdult.findAll();
	}

	@RequestMapping(value = "adult/{id}")
	public ResponseEntity<PeopleAdult> findById(@PathVariable Long id){
		PeopleAdult obj = peopleAdultService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/adult", method = RequestMethod.POST, produces = "application/json")
	public PeopleAdult Post(@Validated @RequestBody PeopleAdult adult) {
		return daoPeopleAdult.save(adult);
	}

	@RequestMapping(value = "/adult/adultId", method = RequestMethod.PUT)
	public ResponseEntity<PeopleAdult>Put(@PathVariable(value = "adultId") long adultId,
			@Valid @RequestBody PeopleAdult newPeopleAdult)
	{
			Optional<PeopleAdult> peopleAdultOld = daoPeopleAdult.findById(adultId);
			if(peopleAdultOld.isPresent()) {
				
				PeopleAdult peopleAdultName = peopleAdultOld.get();
				peopleAdultName.setName(newPeopleAdult.getName());
				daoPeopleAdult.save((peopleAdultName));
				
				PeopleAdult peopleAdultAge = peopleAdultOld.get();
				peopleAdultAge.setAge(newPeopleAdult.getAge());
				daoPeopleAdult.save((peopleAdultAge));

				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}		

}
