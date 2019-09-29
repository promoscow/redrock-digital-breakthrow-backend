package ru.xpendence.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "person_death_group")
@EqualsAndHashCode()
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDeathGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String profession;
    private String email;
}
