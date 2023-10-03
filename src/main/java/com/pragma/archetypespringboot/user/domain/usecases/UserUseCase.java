package com.pragma.archetypespringboot.user.domain.usecases;

import com.pragma.archetypespringboot.user.domain.exceptions.UserNotFoundException;
import com.pragma.archetypespringboot.user.domain.models.UserModel;
import com.pragma.archetypespringboot.user.domain.ports.in.UserServicePort;
import com.pragma.archetypespringboot.user.domain.ports.out.UserPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;
    @Override
    public UserModel save(UserModel userModel) {
        return userPersistencePort.save(userModel);
    }
    @Override
    public UserModel getById(Long id) {
        UserModel userModel = userPersistencePort.getById(id);
        if (userModel == null) throw new UserNotFoundException();
        return userModel;
    }
}