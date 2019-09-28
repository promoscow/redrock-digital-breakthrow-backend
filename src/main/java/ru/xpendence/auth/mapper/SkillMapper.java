package ru.xpendence.auth.mapper;

import org.springframework.stereotype.Component;
import ru.xpendence.auth.dto.SkillDto;
import ru.xpendence.auth.entity.Skills;

@Component
public class SkillMapper {
    public SkillDto toDto(Skills skills) {
        return new SkillDto(
                skills.getName()
        );
    }
}
