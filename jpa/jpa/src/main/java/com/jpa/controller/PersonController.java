package com.jpa.controller;

import com.jpa.entity.PersonEntity;
import com.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/addPersons")
    public PersonEntity addPerson(@RequestBody PersonEntity person) {
        return personService.savePerson(person);
    }

    @PostMapping("/addMorePersons")
    public List<PersonEntity> addPersons(@RequestBody List<PersonEntity> person) {
        return personService.savePersons(person);
    }

    @GetMapping("/persons")
    public List<PersonEntity> findAllPerson() {
        return personService.getPerson();
    }

    @GetMapping("/persons/{id}")
    public PersonEntity findPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

}
