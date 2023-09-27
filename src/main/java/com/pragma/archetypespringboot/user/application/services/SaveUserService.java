package com.pragma.archetypespringboot.user.application.services;

import com.pragma.archetypespringboot.user.application.dtos.requests.SaveUserRequest;
import com.pragma.archetypespringboot.user.application.dtos.responses.GenericUserResponse;

public interface SaveUserService {
    GenericUserResponse saveUser(SaveUserRequest saveUserRequest);
}
