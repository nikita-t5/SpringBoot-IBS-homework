package ru.ibs.test.springBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.test.springBoot.entities.SteeringWheel;

public interface SteeringWheelRepository extends CrudRepository<SteeringWheel, Long> {
}
