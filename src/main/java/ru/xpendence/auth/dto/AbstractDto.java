package ru.xpendence.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
abstract class AbstractDto implements Serializable {

    private Long id;
}
