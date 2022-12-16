package com.mongodbuserdetails.service;

import com.mongodbuserdetails.entity.PersonEntity;
import com.mongodbuserdetails.mapper.PersonMapper;
import com.mongodbuserdetails.model.Person;
import com.mongodbuserdetails.repositry.PersonRepository;
import com.mongodbuserdetails.response.PersonResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class PersonService {

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private final PersonMapper personMapper;

    @Autowired
    private final PersonRepository personRepository;

    public PersonService(KafkaTemplate<String, String> kafkaTemplate, PersonMapper personMapper, PersonRepository personRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }


    public PersonResponse addPerson(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity = personMapper.modelToEntity(person);
        personRepository.save(personEntity);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getId());
        return personResponse;
    }

    @Scheduled(cron = "0/10 * * * * *")
    private void sendToKafka() {
        List<PersonEntity> personEntities = personRepository.findAll();
        kafkaTemplate.send(topicName, String.valueOf(personEntities));
        log.info("Sending mails to kafka broker");


    }

}


