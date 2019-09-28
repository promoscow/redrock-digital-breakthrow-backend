package ru.xpendence.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xpendence.auth.entity.PersonDeathGroup;

public interface PersonDeathGroupDao extends JpaRepository<PersonDeathGroup, Long> {
}
