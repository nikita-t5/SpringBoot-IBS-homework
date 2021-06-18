package ru.ibs.test.springBoot.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.entities.Gear;
import ru.ibs.test.springBoot.repositories.GearRepository;
import ru.ibs.test.springBoot.services.interfaces.GearService;

import java.util.List;

@Service
public class GearServiceImpl implements GearService {

    private GearRepository gearRepository;

    @Autowired
    public GearServiceImpl(GearRepository gearRepository) {
        this.gearRepository = gearRepository;
    }


    @Override
    public Gear findCarById(Long gearId) {
        return gearRepository.findById(gearId).get();
    }

    @Override
    public List<Gear> findAllGears() {
        return (List<Gear>) gearRepository.findAll();
    }

    @Override
    public void addGear(Gear gear) {
        gearRepository.save(gear);
    }

    @Override
    public Gear updateById(Long gearId, Long gearSize, Engine engine) {
        Gear gear = gearRepository.findById(gearId).get();
        gear.setGearSize(gearSize);
        gear.setEngine(engine);
        gearRepository.save(gear);
        return gear;
    }

    @Override
    public void delete(Long gearId) {
        gearRepository.delete(findCarById(gearId));
    }
}
