package com.pragma.archetypespringboot.user.application.services;

import com.pragma.archetypespringboot.user.application.dtos.responses.GenericUserResponse;

public interface GetUserService {
    GenericUserResponse getUserById(Long id);

}
