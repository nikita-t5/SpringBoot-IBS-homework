package ru.ibs.test.springBoot.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.entities.Manual;
import ru.ibs.test.springBoot.repositories.ManualRepository;
import ru.ibs.test.springBoot.services.interfaces.ManualService;

import java.util.List;

@Service
public class ManualServiceImpl implements ManualService {

    private ManualRepository manualRepository;

    @Autowired
    public ManualServiceImpl(ManualRepository manualRepository) {
        this.manualRepository = manualRepository;
    }


    @Override
    public Manual findManualById(Long manualId) {
        return manualRepository.findById(manualId).get();
    }

    @Override
    public List<Manual> findAllManuals() {
        return (List<Manual>) manualRepository.findAll();
    }

    @Override
    public void addManual(Manual manual) {
        manualRepository.save(manual);
    }

    @Override
    public Manual updateById(Long manualId, String type, List<Engine> engines) {
        Manual manual = manualRepository.findById(manualId).get();
        manual.setType(type);
        manual.setEngines(engines);
        manualRepository.save(manual);
        return manual;
    }

    @Override
    public void delete(Long manualId) {
        manualRepository.delete(findManualById(manualId));
    }
}
