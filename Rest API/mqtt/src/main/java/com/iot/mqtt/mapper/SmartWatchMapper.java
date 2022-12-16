package com.iot.mqtt.mapper;

import com.iot.mqtt.entity.SmartWatchEntity;
import com.iot.mqtt.model.SmartWatch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SmartWatchMapper {

    SmartWatchEntity modelToEntity(SmartWatch smartWatch);
}
