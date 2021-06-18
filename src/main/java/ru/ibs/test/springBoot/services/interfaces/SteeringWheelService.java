package ru.ibs.test.springBoot.services.interfaces;

import ru.ibs.test.springBoot.entities.SteeringWheel;

import java.util.List;

public interface SteeringWheelService {

    SteeringWheel findSWById(Long swId);

    List<SteeringWheel> findAllSW();

    void addSW(SteeringWheel steeringWheel);

    SteeringWheel updateById(Long swId, String type);

    void delete(Long swId);
}
