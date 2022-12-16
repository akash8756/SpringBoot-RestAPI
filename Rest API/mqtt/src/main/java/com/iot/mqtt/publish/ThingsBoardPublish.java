package com.iot.mqtt.publish;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class ThingsBoardPublish {


    public static void main(String[] args) {
        String topic = "v1/devices/me/telemetry";
        String content = "{\"Temp\":30,\"Humi\":70}";
        int qos = 0;
        String broker = "tcp://localhost:1882";
        String clientId = "TB1";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setKeepAliveInterval(60);
            System.out.println("please get the token from thingsboard device");
            connOpts.setUserName("HQx9H2wc00QSQq21vZBv");
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected to thingsboard broker");
            System.out.println("Publishing message:" + content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published ");
            System.out.println("Please check data in telemetry of your device on thingsboard");
        } catch (MqttException var10) {
            System.out.println("reason " + var10.getReasonCode());
            System.out.println("msg " + var10.getMessage());
            System.out.println("loc " + var10.getLocalizedMessage());
            System.out.println("cause " + var10.getCause());
            System.out.println("excep " + var10);
            var10.printStackTrace();
        }

    }
}

