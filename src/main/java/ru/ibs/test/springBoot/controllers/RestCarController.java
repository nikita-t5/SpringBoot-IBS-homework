package ru.ibs.test.springBoot.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.test.springBoot.entities.Car;
import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.entities.SteeringWheel;
import ru.ibs.test.springBoot.services.interfaces.CarService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
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
    public Map<String, Object> create(@RequestBody String inputCar) throws IOException {
        Car car = objectMapper.readValue(inputCar, Car.class);
        carService.addCar(car);
        JSONObject response = objectMapper.convertValue(car, JSONObject.class);
        return response;
/*
если body запроса:
{
    "manufacturerName": "DDD",
    "modelName":"333",
    "engine": null,
}
,то создастся объект:
{
    "modelName": "333",
    "engine": null,
    "steeringWheel": null,
    "manufacturerName": "DDD",
    "id": 40
}
если в запросе "engine" не null, то ошибка.

Вопрос: как положить какой-то engine в car?
*/
    }

    @PostMapping(value = {"update/", "update/{id}"})
    public Map<String, Object> updateById(@PathVariable(required = false) Long id, @RequestBody Car car) throws JsonProcessingException {
        if (Objects.isNull(id)) {
            throw new RuntimeException("Empty id!");
        }
        String manufacturerName = car.getManufacturerName();
        String modelName = car.getModelName();
        Engine engine = car.getEngine();
        SteeringWheel steeringWheel = car.getSteeringWheel();
        final Car updatedCar = carService.updateById(id,manufacturerName,modelName,engine,steeringWheel);
        JSONObject response = objectMapper.convertValue(updatedCar, JSONObject.class);
        return response;
    }

    @PostMapping("delete/{id}")
    public Car delete(@PathVariable Long id) {
        Car car = carService.findCarById(id);
        carService.delete(id);
        return car;
    }
}
