package com.example.jpaMapStruct.controller;

import com.example.jpaMapStruct.entity.PersonEntity;
import com.example.jpaMapStruct.mapper.PersonMapper;
import com.example.jpaMapStruct.model.Person;
import com.example.jpaMapStruct.repository.PersonRepository;
import com.example.jpaMapStruct.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class PersonController {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;


    @PostMapping(value = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> savePerson(@RequestBody PersonEntity person) {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);


    }
}
