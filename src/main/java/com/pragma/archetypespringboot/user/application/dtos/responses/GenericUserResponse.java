package com.pragma.archetypespringboot.user.application.dtos.responses;

import lombok.Data;

@Data
public class GenericUserResponse {

    private String name;

    private Integer age;

    private String document;
}
