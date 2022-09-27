package com.example.twoTablesRestAPI.controller;

import com.example.twoTablesRestAPI.model.Person;
import com.example.twoTablesRestAPI.response.PersonResponse;
import com.example.twoTablesRestAPI.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createPerson(@RequestBody Person person) {
        PersonResponse personResponse = personService.createPerson(person);
        log.info("Added");
        return new ResponseEntity<>(personResponse, HttpStatus.OK);

    }
}
