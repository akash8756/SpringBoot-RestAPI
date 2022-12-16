package com.iot.mqtt.service;

import com.iot.mqtt.entity.SmartWatchEntity;
import com.iot.mqtt.mapper.SmartWatchMapper;
import com.iot.mqtt.model.SmartWatch;
import com.iot.mqtt.repository.SmartWatchRepository;
import com.iot.mqtt.response.SmartWatchResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SmartWatchService {

    @Autowired
    private SmartWatchRepository smartWatchRepository;

    @Autowired
    private SmartWatchMapper smartWatchMapper;

    public SmartWatchResponse recordData(SmartWatch smartWatch) {
        SmartWatchEntity smartWatchEntity=smartWatchMapper.modelToEntity(smartWatch);
        log.info("saving records from postman");
        smartWatchRepository.save(smartWatchEntity);
        SmartWatchResponse smartWatchResponse=new SmartWatchResponse();
        smartWatchResponse.setId(smartWatchEntity.getId());
        return smartWatchResponse;
    }
}
