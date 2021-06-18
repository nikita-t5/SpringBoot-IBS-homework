package ru.ibs.test.springBoot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.entities.Gear;
import ru.ibs.test.springBoot.services.interfaces.GearService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/gear", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestGearController {

    private GearService gearService;

    @Autowired
    public RestGearController(GearService gearService) {
        this.gearService = gearService;
    }


    @GetMapping("read/{id}")
    public Gear readById(@PathVariable Long id) {
        return gearService.findCarById(id);
    }

    @GetMapping("read")
    public List<Gear> readAll() {
        return gearService.findAllGears();
    }

    @PostMapping("create")
    public Gear create(@RequestBody Gear gear) {
        gearService.addGear(gear);
        return gear;
    }

    @PostMapping(value = {"update/", "update/{id}"})
    public Gear updateById(@PathVariable(required = false) Long id, @RequestBody Gear gear) {
        if (Objects.isNull(id))
            throw new RuntimeException("Empty id!");
        Long gearSize = gear.getGearSize();
        Engine engine = gear.getEngine();
        final Gear updatedGear = gearService.updateById(id,gearSize,engine);
        return updatedGear;
    }

    @PostMapping("delete/{id}")
    public Gear delete(@PathVariable Long id) {
        Gear gear = gearService.findCarById(id);
        gearService.delete(id);
        return gear;
    }
}
