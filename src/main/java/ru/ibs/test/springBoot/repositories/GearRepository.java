package ru.ibs.test.springBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.test.springBoot.entities.Gear;

public interface GearRepository extends CrudRepository<Gear, Long> {
}
