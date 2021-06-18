package ru.ibs.test.springBoot.services.interfaces;

import ru.ibs.test.springBoot.entities.Car;
import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.entities.SteeringWheel;

import java.util.List;

public interface CarService {

    void addCar(Car car);

    List<Car> findAllCars();

    Car findCarById(Long carId);

    Car updateById(Long carId, String manufacturerName, String modelName, Engine engine, SteeringWheel steeringWheel);

    void delete(Long carId);
}
