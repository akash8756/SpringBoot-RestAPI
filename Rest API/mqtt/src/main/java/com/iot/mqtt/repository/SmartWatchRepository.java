package com.iot.mqtt.repository;

import com.iot.mqtt.entity.SmartWatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartWatchRepository extends JpaRepository<SmartWatchEntity, Long> {
}
