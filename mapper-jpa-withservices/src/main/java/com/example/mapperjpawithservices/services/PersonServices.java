package com.example.mapperjpawithservices.services;

import com.example.mapperjpawithservices.entity.PersonEntity;
import com.example.mapperjpawithservices.mapper.PersonMapper;
import com.example.mapperjpawithservices.model.Person;
import com.example.mapperjpawithservices.repository.PersonRepository;
import com.example.mapperjpawithservices.response.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;


    public PersonResponse save(Person person) {
        PersonEntity personEntity=new PersonEntity();
        personEntity=personMapper.personToEntity(person);
        PersonResponse personResponse = new PersonResponse();
        Long id = (long) ((Math.random() * 20));
        personEntity.setId(id);
        personResponse.setId(personEntity.getId());
       
        return personResponse;
    }

}
