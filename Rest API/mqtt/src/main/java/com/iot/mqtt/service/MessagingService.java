package com.iot.mqtt.service;

import com.iot.mqtt.entity.SmartWatchEntity;
import com.iot.mqtt.model.Payload;
import lombok.extern.log4j.Log4j2;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Log4j2
@Service
public class MessagingService implements CommandLineRunner {

    @Autowired
    private final IMqttClient mqttClient;

    @Autowired
    private final ConfigurableApplicationContext context;

    @Autowired
    private SmartWatchEntity smartWatchEntity;

    @Value("${mqtt.topic}")
    private String topic;

    public MessagingService(IMqttClient mqttClient, ConfigurableApplicationContext context, SmartWatchEntity smartWatchEntity) {
        this.mqttClient = mqttClient;
        this.context = context;
        this.smartWatchEntity = smartWatchEntity;
    }

    public void publish(final String topic, int qos, boolean retained)
            throws MqttException {
        Payload payload=new Payload();
        payload.setUserName(smartWatchEntity.getUserName());
        payload.setHeartRate(smartWatchEntity.getHeartRate());
        payload.setSteps(smartWatchEntity.getSteps());
        payload.setOxygenLevel(smartWatchEntity.getOxygenLevel());
        log.info(payload);

        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(payload.toString().getBytes());
        mqttMessage.setQos(qos);
        mqttMessage.setRetained(retained);
        mqttClient.publish(topic, payload.toString().getBytes(), qos, retained);
    }

    public void subscribe(final String topic) throws MqttException {
        log.info("Messages received:");
        mqttClient.subscribeWithResponse(topic, (tpic, msg) -> {
            log.info(msg.getPayload());
        });
    }

    @Override
    public void run(String... args) throws Exception {
        MessagingService messagingService = new MessagingService(mqttClient, context, smartWatchEntity);
        log.info("Publish method found");
        messagingService.publish(topic, 0, true);
        log.info("Subscribe method found");
        messagingService.subscribe(topic);
    }
}

