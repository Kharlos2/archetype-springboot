package com.pragma.archetypespringboot.user.domain.ports.in;

import com.pragma.archetypespringboot.user.domain.models.UserModel;
import org.springframework.stereotype.Component;

public interface UserServicePort {
    UserModel save(UserModel userModel);

    UserModel getById(Long id);

}
