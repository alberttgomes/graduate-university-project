package com.placa.mae.placamae.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

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

import com.placa.mae.placamae.domain.PeopleKids;
import com.placa.mae.placamae.repository.DAOPeopleKids;
import com.placa.mae.placamae.services.PeopleKidService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ControllerPeopleKids {

	@Autowired
	DAOPeopleKids daoPeopleKids;

	@Autowired
	PeopleKidService daoPeopleKidService;

	@RequestMapping(value = "/kids", method = RequestMethod.GET)
	public List<PeopleKids> get() {
		return daoPeopleKids.findAll();
	}

	@RequestMapping(value = "kids/{id}")
	public ResponseEntity<PeopleKids> findById(@PathVariable Long id){
		PeopleKids obj = daoPeopleKidService.findById(id);
		return ResponseEntity.ok().body(obj);
	}


	@RequestMapping(value = "/kids", method = RequestMethod.POST)
	public PeopleKids post(@Validated @RequestBody PeopleKids kids) {
		return daoPeopleKids.save(kids);
	}

	@DeleteMapping( value = "/kids/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id){
		daoPeopleKids.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/kids/kidsId")
	public ResponseEntity<PeopleKids> put(@PathVariable Long kidsId, @Valid @RequestBody PeopleKids newPeopleKids) {

		Optional<PeopleKids> optionalObj  = daoPeopleKids.findById(kidsId);
		PeopleKids peopleKids = optionalObj.get();

		peopleKids.setName(!Objects.isNull(newPeopleKids.getName()) ? newPeopleKids.getName() : peopleKids.getName());
		peopleKids.setAge(!Objects.isNull(newPeopleKids.getAge()) ? newPeopleKids.getAge() : peopleKids.getAge());
		peopleKids.setEmail(!Objects.isNull(newPeopleKids.getEmail()) ? newPeopleKids.getEmail() : peopleKids.getEmail());
		peopleKids.setPassword(!Objects.isNull(newPeopleKids.getPassword()) ? newPeopleKids.getPassword() : peopleKids.getPassword());
		newPeopleKids = daoPeopleKids.save(peopleKids);
		
		return ResponseEntity.ok().body(newPeopleKids);

    }

}	
