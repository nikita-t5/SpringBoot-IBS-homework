package ru.ibs.test.springBoot.services.interfaces;

import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.entities.Gear;
import ru.ibs.test.springBoot.entities.Manual;

import java.util.List;

public interface EngineService {

    List<Engine> findAllEngines();

    Engine findEngineById(Long engineId);

    void addEngine(Engine engine);

    Engine updateById(Long engineId, String type, List<Gear> gears, List<Manual> manuals);

    void delete(Long engineId);
}

