package ru.xpendence.auth.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmailDto {
    private Long id;
    private List<String> urls;
}
