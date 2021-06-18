package ru.ibs.test.springBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.test.springBoot.entities.Manual;

public interface ManualRepository extends CrudRepository<Manual, Long> {
}
