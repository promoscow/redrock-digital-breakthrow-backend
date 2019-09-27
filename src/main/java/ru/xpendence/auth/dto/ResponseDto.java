package ru.xpendence.auth.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class ResponseDto implements Serializable {

    private Boolean success;
}
