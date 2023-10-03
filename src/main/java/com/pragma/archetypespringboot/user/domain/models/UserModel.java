package com.pragma.archetypespringboot.user.domain.models;

import com.pragma.archetypespringboot.user.domain.exceptions.InvalidUserDateBirthException;
import com.pragma.archetypespringboot.user.domain.exceptions.InvalidUserParameterException;
import com.pragma.archetypespringboot.user.domain.exceptions.MinorUserException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
public class  UserModel {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private String document;

    public UserModel(Long id, String name, LocalDate birthDate, String document) {

        if (!birthDate.toString().matches("^(?:(?:19|20)\\d\\d)-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12][0-9]|3[01])$")) {
            throw new InvalidUserDateBirthException();
        }

        if (Period.between(birthDate,LocalDate.now()).getYears()<18) throw new MinorUserException();

        if (!document.matches("\\d{7,15}")) {
            throw new InvalidUserParameterException();
        }

        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.document = document;
    }
}
