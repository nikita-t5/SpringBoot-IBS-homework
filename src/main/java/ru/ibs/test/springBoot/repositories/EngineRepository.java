package ru.ibs.test.springBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.test.springBoot.entities.Engine;

public interface EngineRepository extends CrudRepository<Engine, Long> {
}
