package ru.ibs.test.springBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.test.springBoot.entities.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
}
