package ru.ibs.test.springBoot.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.test.springBoot.entities.Car;
import ru.ibs.test.springBoot.entities.Engine;
import ru.ibs.test.springBoot.entities.SteeringWheel;
import ru.ibs.test.springBoot.repositories.CarRepository;
import ru.ibs.test.springBoot.services.interfaces.CarService;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> findAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Car findCarById(Long carId) {
        return carRepository.findById(carId).get();
    }

    @Override
    public Car updateById(Long carId, String manufacturerName, String modelName, Engine engine, SteeringWheel steeringWheel) {
        Car car = carRepository.findById(carId).get();
        car.setManufacturerName(manufacturerName);
        car.setModelName(modelName);
        car.setEngine(engine);
        car.setSteeringWheel(steeringWheel);
        carRepository.save(car);
        return car;
    }

    @Override
    public void delete(Long carId) {
        carRepository.delete(findCarById(carId));
    }
}
