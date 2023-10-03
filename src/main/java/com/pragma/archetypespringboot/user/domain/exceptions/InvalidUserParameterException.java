package com.pragma.archetypespringboot.user.domain.exceptions;

public class InvalidUserParameterException extends IllegalArgumentException{

    public InvalidUserParameterException(String message) { super(message); }

}
