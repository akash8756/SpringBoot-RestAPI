package com.mongodbuserdetails.controller;

import com.mongodbuserdetails.model.Person;
import com.mongodbuserdetails.response.PersonResponse;
import com.mongodbuserdetails.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(path = "/persons" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> addPerson(@RequestBody Person person){
        PersonResponse personResponse=personService.addPerson(person);
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }


}
