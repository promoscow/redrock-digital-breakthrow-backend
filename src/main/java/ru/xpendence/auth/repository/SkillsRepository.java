package ru.xpendence.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xpendence.auth.entity.Role;
import ru.xpendence.auth.entity.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Long> {
}
