package com.iot.mqtt.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "iot_watch_entity")
public class SmartWatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "heart_rate")
    private Integer heartRate;

    @Column(name = "oxygen_level")
    private Integer oxygenLevel;

    @Column(name = "steps")
    private Integer steps;

}
