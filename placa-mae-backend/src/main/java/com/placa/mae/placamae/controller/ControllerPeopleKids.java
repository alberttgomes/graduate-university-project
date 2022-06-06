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

	@RequestMapping(value = "/kids", method = RequestMethod.GET)
	public List<PeopleKids> Get() {
		return daoPeopleKids.findAll();
	}

	@RequestMapping(value = "kids/{id}")
	public ResponseEntity<PeopleKids> findById(@PathVariable Long id){
		PeopleKids obj = daoPeopleKidService.findById(id);
		return ResponseEntity.ok().body(obj);
	}



	@RequestMapping(value = "/kids", method = RequestMethod.POST)
	public PeopleKids Post(@Validated @RequestBody PeopleKids kids) {
		return daoPeopleKids.save(kids);
	}

    }

	@DeleteMapping( value = "/kids/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id){
		daoPeopleKids.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/kids/kidsId")
	public ResponseEntity<PeopleAdult>update(@PathVariable(value = "kidsId") long kidsId, @Valid @RequestBody Peoplekids newPeopleKids) {

		Optional<PeopleKids> optionalObj  = daoPeopleKids.findById(id);
		PeopleKids peopleKids = optionalObj.get();

		peopleKids.setName(!Objects.isNull(obj.getName()) ? obj.getName() : peopleKids.getName());
		peopleKids.setAge(!Objects.isNull(obj.getAge()) ? obj.getAge() : peopleKids.getAge());
		peopleKids.setEmail(!Objects.isNull(obj.getEmail()) ? obj.getEmail() : peopleKids.getEmail());
		peopleKids.setPassword(!Objects.isNull(obj.getPassword()) ? obj.getPassword() : peopleKids.getPassword());
		obj = daoPeopleKids.save(peopleKids);
		return ResponseEntity.ok().body(obj);

    }
