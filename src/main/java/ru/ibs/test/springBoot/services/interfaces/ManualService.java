package ru.ibs.test.springBoot.services.interfaces;

import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.entities.Manual;

import java.util.List;

public interface ManualService {

    Manual findManualById(Long manualId);

    List<Manual> findAllManuals();

    void addManual(Manual manual);

    Manual updateById(Long manualId, String type, List<Engine> engines);

    void delete(Long manualId);
}
