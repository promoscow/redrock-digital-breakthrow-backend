package ru.xpendence.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailMessageDto implements Serializable {

    private String to;
    private String from;
    private String subject;
    private String text;
}
