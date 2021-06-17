package ru.ibs.test.springBoot.services.interfaces;

import ru.ibs.test.springBoot.entities.Car;

import java.util.List;

public interface CarService {
    Car addCar(Car car);

    List<Car> findAllCars();

    Car findCarById(Long carId);

    Car updateById(Long carId, String manufacturerName, String modelName);

    void delete(Long carId);
}
