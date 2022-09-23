package com.example.mapperjpawithservices.controller;

import com.example.mapperjpawithservices.entity.PersonEntity;
import com.example.mapperjpawithservices.model.Person;
import com.example.mapperjpawithservices.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    PersonServices personServices;
    @Autowired
    PersonEntity personEntity;

    @PostMapping(path = "/persons")
    public ResponseEntity<Person> save(@RequestBody Person person){
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
