package com.jobscheduler.springbootjobscheduler.service;

import com.jobscheduler.springbootjobscheduler.model.User;
import com.jobscheduler.springbootjobscheduler.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Log4j2
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Scheduled(fixedRate = 5000)
    public void add2DBJob() {
        User user = new User();
        user.setName("user" + new Random().nextInt(374483));
        userRepository.save(user);
       log.info("add service call in " + new Date().toString());
    }

 /*   @Scheduled(cron = "0/15 * * * * *")
    public void fetchDBJob() {
        List<User> users = userRepository.findAll();
        System.out.println("fetch service call in " + new Date().toString());
        System.out.println("no of record fetched : " + users.size());
        log.info("users : {}", users);
    }*/
}
