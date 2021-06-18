package ru.ibs.test.springBoot.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.test.springBoot.entities.Car;
import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.entities.Gear;
import ru.ibs.test.springBoot.entities.Manual;
import ru.ibs.test.springBoot.repositories.EngineRepository;
import ru.ibs.test.springBoot.services.interfaces.EngineService;

import java.util.List;

@Service
public class EngineServiceImpl implements EngineService {

    private EngineRepository engineRepository;

    @Autowired
    public EngineServiceImpl(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }


    @Override
    public List<Engine> findAllEngines() {
        return (List<Engine>) engineRepository.findAll();
    }

    @Override
    public Engine findEngineById(Long engineId) {
        return engineRepository.findById(engineId).get();
    }

    @Override
    public void addEngine(Engine engine) {
        engineRepository.save(engine);
    }

    @Override
    public void updateById(Long engineId, String type, List<Gear> gears, List<Manual> manuals) {
        Engine engine = engineRepository.findById(engineId).get();
        engine.setType(type);
        engine.setGears(gears);
        engine.setManuals(manuals);
        engineRepository.save(engine);
//        return engine;
    }

    @Override
    public void delete(Long engineId) {
        engineRepository.delete(findEngineById(engineId));
    }



}
