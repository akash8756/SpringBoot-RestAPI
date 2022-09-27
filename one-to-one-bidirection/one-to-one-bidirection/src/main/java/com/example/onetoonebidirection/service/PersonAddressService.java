package com.example.onetoonebidirection.service;

import com.example.onetoonebidirection.entity.AddressEntity;
import com.example.onetoonebidirection.entity.PersonEntity;
import com.example.onetoonebidirection.mapper.PersonAddressMapper;
import com.example.onetoonebidirection.model.Address;
import com.example.onetoonebidirection.model.Person;
import com.example.onetoonebidirection.repository.PersonRepository;
import com.example.onetoonebidirection.response.PersonResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PersonAddressService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final PersonAddressMapper personAddressMapper;

    public PersonAddressService(PersonRepository personRepository, PersonAddressMapper personAddressMapper) {
        this.personRepository = personRepository;
        this.personAddressMapper = personAddressMapper;
    }


    public PersonResponse createPerson(Person person) {
        PersonEntity personEntity = null;
        personEntity = personAddressMapper.personToEntity(person);

        AddressEntity addressEntity = null;
        addressEntity = personAddressMapper.personToEntity(new Address());
        personRepository.save(personEntity);
        log.info("Saving person entity");
        PersonResponse personResponse = new PersonResponse();
        log.info("Getting response from the person-response");
        log.info("Id has been set in the person response");
        personResponse.setId(personEntity.getId());

        return personResponse;
    }

    public Person getPerson(Long id) {
        Person person = new Person();
        PersonEntity personEntity = personRepository.findById(id).orElse(null);
        if (personEntity != null) {
            log.info("Person id : " + id + "found");
            person = personAddressMapper.entityToPerson(personEntity);
        } else {
            log.info("No person id" + id + "found");
        }
        return person;

    }

    public void deletePerson(Long id) {
        Optional<PersonEntity> peopleEntityOptional = personRepository.findById(id);
        if (peopleEntityOptional.isPresent()) {
            log.info("Person id : " + id + "found");
            personRepository.deleteById(id);
        } else {
            log.info("Person id " + id + "Not found");
        }

    }


}
