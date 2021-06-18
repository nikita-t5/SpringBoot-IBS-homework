package ru.ibs.test.springBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.test.springBoot.entities.SteeringWheel;
import ru.ibs.test.springBoot.services.interfaces.SteeringWheelService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/steeringWheel", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestSteeringWheelController {

    private SteeringWheelService steeringWheelService;

    @Autowired
    public RestSteeringWheelController(SteeringWheelService steeringWheelService) {
        this.steeringWheelService = steeringWheelService;
    }


    @GetMapping("read/{id}")
    public SteeringWheel readById(@PathVariable Long id) {
        return steeringWheelService.findSWById(id);
    }

    @GetMapping("read")
    public List<SteeringWheel> readAll() {
        return steeringWheelService.findAllSW();
    }

    @PostMapping("create")
    public SteeringWheel create(@RequestBody SteeringWheel steeringWheel) {
        steeringWheelService.addSW(steeringWheel);
        return steeringWheel;
    }

    @PostMapping(value = {"update/", "update/{id}"})
    public SteeringWheel updateById(@PathVariable(required = false) Long id, @RequestBody SteeringWheel steeringWheel) {
        if (Objects.isNull(id))
            throw new RuntimeException("Empty id!");
        String type = steeringWheel.getType();
        final SteeringWheel updatedSW = steeringWheelService.updateById(id, type);
        return updatedSW;
    }

    @PostMapping("delete/{id}")
    public SteeringWheel delete(@PathVariable Long id) {
        SteeringWheel steeringWheel = steeringWheelService.findSWById(id);
        steeringWheelService.delete(id);
        return steeringWheel;
    }
}
