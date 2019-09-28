package ru.xpendence.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.xpendence.auth.entity.Education;
import ru.xpendence.auth.entity.Gender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PersonDto {
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private List<String> skills = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Education education;
    private String fromProfession;

}
