package ru.ibs.test.springBoot.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.test.springBoot.entities.Car;
import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.entities.SteeringWheel;
import ru.ibs.test.springBoot.services.interfaces.CarService;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping(value = "/api/car", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestCarController {

    private CarService carService;

    private ObjectMapper objectMapper;

    @Autowired
    public RestCarController(CarService carService, ObjectMapper objectMapper) {
        this.carService = carService;
        this.objectMapper = objectMapper;
    }


    @GetMapping("read/{id}")
    public Car readById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

    @GetMapping("read")
    public List<Car> readAll() {
        return carService.findAllCars();
    }

    @PostMapping("create")
    public Car create(@RequestBody Car car) {
        carService.addCar(car);
        return car;
    }

    @PostMapping(value = {"update/", "update/{id}"})
    public Car updateById(@PathVariable(required = false) Long id, @RequestBody Car car) {
        if (Objects.isNull(id))
            throw new RuntimeException("Empty id!");
        String manufacturerName = car.getManufacturerName();
        String modelName = car.getModelName();
        Engine engine = car.getEngine();
        SteeringWheel steeringWheel = car.getSteeringWheel();
        final Car updatedCar = carService.updateById(id,manufacturerName,modelName,engine,steeringWheel);
        return updatedCar;
    }

    @PostMapping("delete/{id}")
    public Car delete(@PathVariable Long id) {
        Car car = carService.findCarById(id);
        carService.delete(id);
        return car;
    }
}
