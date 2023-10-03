package com.pragma.archetypespringboot.user.application.dtos.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GenericUserResponse {

    private String name;

    private LocalDate dateBirth;

    private String document;
}
