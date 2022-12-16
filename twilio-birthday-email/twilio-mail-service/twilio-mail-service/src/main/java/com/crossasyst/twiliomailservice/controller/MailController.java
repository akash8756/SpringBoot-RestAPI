package com.crossasyst.twiliomailservice.controller;

import com.crossasyst.twiliomailservice.model.EmailRequest;
import com.crossasyst.twiliomailservice.service.MailService;
import com.jayway.jsonpath.JsonPath;
import com.sendgrid.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class MailController {

    @Value("${topic.name.consumer")
    private String topicName;

    @Autowired
    private MailService mailService;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, JSONObject> payload) {
        log.info("Topic Name: {}", topicName);
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partition: {}", payload.partition());

        String data = String.valueOf(payload.value());
        log.info("Received following details from kafka broker");
        String email = JsonPath.read(data, "$.people.email_id");
        String firstName = JsonPath.read(data, "$.people.firstName");
        String lastName = JsonPath.read(data, "$.people.lastName");

        EmailRequest emailRequest = new EmailRequest();
        log.info("Sending mail id to the mail service");
        emailRequest.setTo(email);
        mailService.setUserDetails(firstName, lastName);

        Response response = mailService.sendEmail(emailRequest);


        if (response.getStatusCode() == 200 || response.getStatusCode() == 202) {
            log.info("Your mail has been sent successfully to the email id : {} ",email );
        } else {
            log.info("failed to send mail to the {}");
        }
    }

}

