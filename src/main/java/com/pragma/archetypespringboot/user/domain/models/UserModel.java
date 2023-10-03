package com.pragma.archetypespringboot.user.domain.models;

import com.pragma.archetypespringboot.user.domain.exceptions.InvalidUserParameterException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserModel {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private String document;

    public UserModel(Long id, String name, LocalDate birthDate, String document) {
        this.id = id;
        this.name = name;

        this.birthDate = birthDate;
        if (!birthDate.toString().matches("^(?:(?:19|20)\\d\\d)-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12][0-9]|3[01])$")) {
            // Age verification > 18
            throw new InvalidUserParameterException("Enter a valid dateBirth, the format is YYYY-MM-DD");
        }

        this.document = document;
        if (!document.matches("\\d{7,15}")) {
            throw new InvalidUserParameterException("The field document cannot be less than 7 and more than 15 characters and must be only numbers");
        }

    }
}
