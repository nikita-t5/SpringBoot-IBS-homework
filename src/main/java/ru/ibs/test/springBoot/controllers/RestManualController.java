package ru.ibs.test.springBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.entities.Manual;
import ru.ibs.test.springBoot.services.interfaces.ManualService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/manual", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestManualController {

    private ManualService manualService;

    @Autowired
    public RestManualController(ManualService manualService) {
        this.manualService = manualService;
    }


    @GetMapping("read/{id}")
    public Manual readById(@PathVariable Long id) {
        return manualService.findManualById(id);
    }

    @GetMapping("read")
    public List<Manual> readAll() {
        return manualService.findAllManuals();
    }

    @PostMapping("create")
    public Manual create(@RequestBody Manual manual) {
        manualService.addManual(manual);
        return manual;
    }

    @PostMapping(value = {"update/", "update/{id}"})
    public Manual updateById(@PathVariable(required = false) Long id, @RequestBody Manual manual) {
        if (Objects.isNull(id))
            throw new RuntimeException("Empty id!");
        String type = manual.getType();
        List<Engine> engines = manual.getEngines();
        final Manual updatedManual = manualService.updateById(id, type, engines);
        return updatedManual;
    }

    @PostMapping("delete/{id}")
    public Manual delete(@PathVariable Long id) {
        Manual manual = manualService.findManualById(id);
        manualService.delete(id);
        return manual;
    }
}
