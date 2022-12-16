package com.crossasyst.userdetailsservice.service;

import com.crossasyst.userdetailsservice.Response.UserResponse;
import com.crossasyst.userdetailsservice.enitity.UsersEntity;
import com.crossasyst.userdetailsservice.mapper.UserDetailsMapper;
import com.crossasyst.userdetailsservice.model.People;
import com.crossasyst.userdetailsservice.model.Users;
import com.crossasyst.userdetailsservice.repository.UserDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class UserService {

    @Autowired
    private final UserDetailsMapper userDetailsMapper;

    @Autowired
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    private final KafkaTemplate<String, JSONObject> kafkaTemplate;

    @Value("${topic.name.producer}")
    private String topicName;

    public UserService(UserDetailsMapper userDetailsMapper, UserDetailsRepository userDetailsRepository, KafkaTemplate<String, JSONObject> kafkaTemplate) {
        this.userDetailsMapper = userDetailsMapper;
        this.userDetailsRepository = userDetailsRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public UserResponse addPerson(Users users) {
        UsersEntity usersEntity=userDetailsMapper.modelToEntity(users);
        userDetailsRepository.save(usersEntity);
        UserResponse userResponse=new UserResponse();
        userResponse.setId(usersEntity.getId());
        log.info("Your details has been saved successfully, your response id is {}",userResponse);
        return userResponse;
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void findBirthdate(){
       List<UsersEntity> usersEntityList=userDetailsRepository.findAllByDayMonth()  ;
       for(UsersEntity records:usersEntityList){
           People people=new People();
           people.setFirstName(records.getFirstName());
           people.setLastName(records.getLastName());
           people.setEmail_id(records.getEmailId());
           JSONObject jsonObject=new JSONObject();
           jsonObject.put("details", people);
           log.info("Sending details to the kafka broker :- {}  ",topicName);
           kafkaTemplate.send(topicName, jsonObject);

        }
    }
}
