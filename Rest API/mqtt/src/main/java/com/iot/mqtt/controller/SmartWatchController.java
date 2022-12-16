package com.iot.mqtt.controller;

import com.iot.mqtt.model.SmartWatch;
import com.iot.mqtt.response.SmartWatchResponse;
import com.iot.mqtt.service.SmartWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SmartWatchController {

    @Autowired
    private final SmartWatchService smartWatchService;

    public SmartWatchController(SmartWatchService smartWatchService) {
        this.smartWatchService = smartWatchService;
    }

    @PostMapping(path = "/addrecords")
    public ResponseEntity<SmartWatchResponse> recordData(@RequestBody SmartWatch smartWatch){
        SmartWatchResponse smartWatchResponse=smartWatchService.recordData(smartWatch);
        return new ResponseEntity<>(smartWatchResponse, HttpStatus.CREATED);
    }
}

