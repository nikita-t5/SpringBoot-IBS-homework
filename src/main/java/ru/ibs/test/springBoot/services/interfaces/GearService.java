package ru.ibs.test.springBoot.services.interfaces;

import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.entities.Gear;

import java.util.List;

public interface GearService {

    Gear findCarById(Long gearId);

    List<Gear> findAllGears();

    void addGear(Gear gear);

    Gear updateById(Long gearId, Long gearSize, Engine engine);

    void delete(Long gearId);
}
