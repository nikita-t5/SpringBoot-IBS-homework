package ru.ibs.test.springBoot.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.services.interfaces.EngineService;

import java.io.IOException;
import java.util.List;

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
    public Engine create(@RequestBody String inputEngine) throws IOException {
        Engine engine = objectMapper.readValue(inputEngine, Engine.class);
        engineService.addEngine(engine);
        return engine;
    }

    @PostMapping("update/{id}")  //получаем id в параметрах, а поля в body
    public Engine updateById(@PathVariable Long id, @RequestBody String inputEngine) throws JsonProcessingException {
        Engine engine = objectMapper.readValue(inputEngine, Engine.class);
        engineService.updateById(id,engine.getType(),engine.getGears(),engine.getManuals());
        return engineService.findEngineById(id);
    }

    @PostMapping("delete/{id}")
    public Engine delete(@PathVariable Long id) {
        Engine engine = engineService.findEngineById(id);
        engineService.delete(id);
        return engine;
    }
}
