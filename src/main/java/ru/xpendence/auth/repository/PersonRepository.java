package ru.xpendence.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xpendence.auth.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
