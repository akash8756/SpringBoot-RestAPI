package com.iot.mqtt.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payload {
    private String userName;
    private Integer heartRate;
    private Integer oxygenLevel;
    private Integer steps;

}
