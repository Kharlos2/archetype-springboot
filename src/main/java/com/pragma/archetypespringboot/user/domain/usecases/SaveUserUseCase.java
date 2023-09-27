package com.pragma.archetypespringboot.user.domain.usecases;

import com.pragma.archetypespringboot.user.domain.models.UserModel;
import com.pragma.archetypespringboot.user.domain.ports.in.SaveUserServicePort;
import com.pragma.archetypespringboot.user.domain.ports.out.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveUserUseCase implements SaveUserServicePort {

    private final UserPersistencePort userPersistencePort;

    @Override
    public UserModel saveUser(UserModel userModel) {
        return userPersistencePort.saveUser(userModel);
    }

}
