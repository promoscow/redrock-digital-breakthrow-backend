package ru.xpendence.auth.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.xpendence.auth.base.RoleType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "roles")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Role extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private RoleType roleType;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    public Role(RoleType roleType) {
        this.roleType = roleType;
    }
}
