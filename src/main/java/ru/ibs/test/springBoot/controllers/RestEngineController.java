package ru.ibs.test.springBoot.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.test.springBoot.entities.*;
import ru.ibs.test.springBoot.services.interfaces.EngineService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/engine", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestEngineController {

    private EngineService engineService;

    private ObjectMapper objectMapper;

    @Autowired
    public RestEngineController(EngineService engineService, ObjectMapper objectMapper) {
        this.engineService = engineService;
        this.objectMapper = objectMapper;
    }


    @GetMapping("read")
    public List<Engine> readAll(){
        return engineService.findAllEngines();
    }

    @GetMapping("read/{id}")
    public Engine readById(@PathVariable Long id) {
        return engineService.findEngineById(id);
    }

    @PostMapping("create")
    public Engine create(@RequestBody Engine engine) {
        engineService.addEngine(engine);
        return engine;
    }

    @PostMapping(value = {"update/", "update/{id}"})
    public Engine updateById(@PathVariable(required = false) Long id, @RequestBody Engine engine) {
        if (Objects.isNull(id))
            throw new RuntimeException("Empty id!");
        String type = engine.getType();
        List<Gear> gears = engine.getGears();
        List<Manual> manuals = engine.getManuals();
        final Engine updateEngine = engineService.updateById(id,type,gears,manuals);
        return updateEngine;
    }

    @PostMapping("delete/{id}")
    public Engine delete(@PathVariable Long id) {
        Engine engine = engineService.findEngineById(id);
        engineService.delete(id);
        return engine;
    }
}
