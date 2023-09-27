package com.pragma.archetypespringboot.user.domain.usecases;

import com.pragma.archetypespringboot.user.domain.exceptions.UserNotFoundException;
import com.pragma.archetypespringboot.user.domain.models.UserModel;
import com.pragma.archetypespringboot.user.domain.ports.in.GetUserServicePort;
import com.pragma.archetypespringboot.user.domain.ports.out.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUserUseCase implements GetUserServicePort {

    private final UserPersistencePort userPersistencePort;

    @Override
    public UserModel getUserById(Long id) {
        UserModel userModel = userPersistencePort.getUserById(id);
        if (userModel == null) throw new UserNotFoundException();
        return userModel;
    }
}
