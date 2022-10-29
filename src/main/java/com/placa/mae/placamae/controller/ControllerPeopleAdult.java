package com.placa.mae.placamae.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.placa.mae.placamae.domain.PeopleAdult;
import com.placa.mae.placamae.repository.DAOPeopleAdult;
import com.placa.mae.placamae.services.PeopleAdultService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ControllerPeopleAdult {

	@Autowired
	private PeopleAdultService peopleAdultService;

	@Autowired
	DAOPeopleAdult daoPeopleAdult;

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

	@RequestMapping(value = "/adults", method = RequestMethod.POST, produces = "application/json")
	public PeopleAdult post(@Validated @RequestBody PeopleAdult adult) {
		return daoPeopleAdult.save(adult);
	}

	@RequestMapping(value = "/adults/adultId", method = RequestMethod.PUT)
	public ResponseEntity<PeopleAdult>put(@PathVariable(value = "adultId") long adultId,
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

				PeopleAdult peopleAdultEmail = peopleAdultOld.get();
				peopleAdultEmail.setEmail(newPeopleAdult.getEmail());
				daoPeopleAdult.save((peopleAdultEmail));

				PeopleAdult peopleAdultPassword = peopleAdultOld.get();
				peopleAdultPassword.setPassword(newPeopleAdult.getPassword());
				daoPeopleAdult.save((peopleAdultPassword));

				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}		

}
