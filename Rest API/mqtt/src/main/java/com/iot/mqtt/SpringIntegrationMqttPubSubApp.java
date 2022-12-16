package com.iot.mqtt;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringIntegrationMqttPubSubApp{

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationMqttPubSubApp.class, args);
	}


}
