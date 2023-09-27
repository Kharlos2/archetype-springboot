package com.pragma.archetypespringboot.user.domain.ports.in;

import com.pragma.archetypespringboot.user.domain.models.UserModel;

public interface GetUserServicePort {
    UserModel getUserById(Long id);
}
