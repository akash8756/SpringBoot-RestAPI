package com.example.jpaMapStruct.service;

import com.example.jpaMapStruct.entity.PersonEntity;
import com.example.jpaMapStruct.mapper.PersonMapper;
import com.example.jpaMapStruct.model.Person;
import com.example.jpaMapStruct.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;

    public Person savePerson(PersonEntity personEntity){
        Person persons= (personRepository.save(personMapper.entityToPerson(personEntity)));
        return persons;

    }
}
