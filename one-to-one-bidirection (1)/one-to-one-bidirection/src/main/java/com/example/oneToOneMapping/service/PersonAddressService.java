package com.example.oneToOneMapping.service;

import com.example.oneToOneMapping.entity.AddressEntity;
import com.example.oneToOneMapping.entity.PersonEntity;
import com.example.oneToOneMapping.mapper.AddressMapper;
import com.example.oneToOneMapping.mapper.PersonAddressMapper;
import com.example.oneToOneMapping.model.Address;
import com.example.oneToOneMapping.model.Person;
import com.example.oneToOneMapping.repository.PersonRepository;
import com.example.oneToOneMapping.response.PersonResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PersonAddressService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private  final PersonAddressMapper personAddressMapper;

    @Autowired
    private final AddressMapper addressMapper;

    public PersonAddressService(PersonRepository personRepository, PersonAddressMapper personAddressMapper, AddressMapper addressMapper) {
        this.personRepository = personRepository;
        this.personAddressMapper = personAddressMapper;
        this.addressMapper = addressMapper;
    }

    public PersonResponse createPerson(Person person) {
        PersonEntity personEntity= null;
        personEntity= personAddressMapper.personToEntity(person);

        AddressEntity addressEntity = addressMapper.addressToEntity(person.getAddress());
        personEntity.setAddress(addressEntity);
        addressEntity.setPerson(personEntity);

        log.info("Person saved in the database");
        personRepository.save(personEntity);

        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getId());

        return personResponse;
    }

    @Cacheable(cacheNames = "person", key = "#id")
    public Person getPerson(Long id) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);
        Person person =new Person();
        Address address=new Address();
        if (personEntityOptional.isPresent()) {
            AddressEntity addressEntity = personEntityOptional.get().getAddress();
            PersonEntity personEntity = personEntityOptional.get();
            person = personAddressMapper.entityToPerson(personEntity);
            address = addressMapper.entityToAddress(addressEntity);
            log.info("Fetching from the database");
            person.setAddress(address);

        } else {
            log.info("No such id found");
        }
        return person;

    }

    public void deletePerson(Long id) {
        Optional<PersonEntity> peopleEntityOptional = personRepository.findById(id);
        if (peopleEntityOptional.isPresent()) {
            personRepository.deleteById(id);
            log.info("Delete from thes database");
        } else {
            log.info("Person id " + id+ "Not found");
        }

    }

    @CachePut(cacheNames = "person", key = "#id")
    public Person updatePerson(Long id, Person person) {
        PersonEntity personEntity=new PersonEntity();
        Optional<PersonEntity> optionalPersonEntity=personRepository.findById(id);
        if(optionalPersonEntity.isPresent()){

            /*personEntity.setFirstName(person.getFirstName());
            personEntity.setLastName(person.getLastName());*/
            personAddressMapper.personToEntity(person);
            personRepository.save(personEntity);
            log.info("Updated");
        } else {
            log.info("Person id " + id+ "Not found");
        }
        return person;
    }
}
