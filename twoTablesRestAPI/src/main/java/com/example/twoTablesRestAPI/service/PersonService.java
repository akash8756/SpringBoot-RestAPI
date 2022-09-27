package com.example.twoTablesRestAPI.service;

import com.example.twoTablesRestAPI.entity.AddressEntity;
import com.example.twoTablesRestAPI.entity.PersonEntity;
import com.example.twoTablesRestAPI.model.Person;
import com.example.twoTablesRestAPI.response.PersonResponse;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

   /* @Autowired
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }*/


    public PersonResponse createPerson(Person person) {


        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLineOne(person.getAddress().getAddressLineOne());
        addressEntity.setAddressLineTwo(person.getAddress().getAddressLineTwo());
        addressEntity.setCity(person.getAddress().getCity());
        addressEntity.setState(person.getAddress().getState());
        addressEntity.setZipCode(person.getAddress().getZipCode());

        PersonEntity personEntity = new PersonEntity();
        PersonResponse personResponse = new PersonResponse();
        Long id = (long) Math.random();
        personEntity.setId(id);
        personResponse.setId(personEntity.getId());

        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAddressEntity(addressEntity);


        return personResponse;

    }
}
