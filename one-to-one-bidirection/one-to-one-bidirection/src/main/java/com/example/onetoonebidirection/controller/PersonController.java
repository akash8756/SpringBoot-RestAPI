package com.example.onetoonebidirection.controller;

import com.example.onetoonebidirection.model.Person;
import com.example.onetoonebidirection.response.PersonResponse;
import com.example.onetoonebidirection.service.PersonAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private final PersonAddressService personAddressService;

    public PersonController(PersonAddressService personAddressService) {
        this.personAddressService = personAddressService;
    }

    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createPerson(@RequestBody Person person) {
        PersonResponse personResponse = personAddressService.createPerson(person);
        return new ResponseEntity<>(personResponse, HttpStatus.CREATED);
    }
}