package ru.ibs.test.springBoot.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.test.springBoot.entities.SteeringWheel;
import ru.ibs.test.springBoot.repositories.SteeringWheelRepository;
import ru.ibs.test.springBoot.services.interfaces.SteeringWheelService;

import java.util.List;

@Service
public class SteeringWheelServiceImpl implements SteeringWheelService {

    private SteeringWheelRepository steeringWheelRepository;

    @Autowired
    public SteeringWheelServiceImpl(SteeringWheelRepository steeringWheelRepository) {
        this.steeringWheelRepository = steeringWheelRepository;
    }

    @Override
    public SteeringWheel findSWById(Long swId) {
        return steeringWheelRepository.findById(swId).get();
    }

    @Override
    public List<SteeringWheel> findAllSW() {
        return (List<SteeringWheel>) steeringWheelRepository.findAll();
    }

    @Override
    public void addSW(SteeringWheel steeringWheel) {
        steeringWheelRepository.save(steeringWheel);
    }

    @Override
    public SteeringWheel updateById(Long swId, String type) {
        SteeringWheel steeringWheel = steeringWheelRepository.findById(swId).get();
        steeringWheel.setType(type);
        steeringWheelRepository.save(steeringWheel);
        return steeringWheel;
    }

    @Override
    public void delete(Long swId) {
        steeringWheelRepository.delete(findSWById(swId));
    }
}
