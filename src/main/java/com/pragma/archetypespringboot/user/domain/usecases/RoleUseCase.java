package com.pragma.archetypespringboot.user.domain.usecases;

import com.pragma.archetypespringboot.user.domain.models.RoleModel;
import com.pragma.archetypespringboot.user.domain.models.UserModel;
import com.pragma.archetypespringboot.user.domain.ports.in.RoleServicePort;
import com.pragma.archetypespringboot.user.domain.ports.in.UserServicePort;
import com.pragma.archetypespringboot.user.domain.ports.out.RolePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleUseCase implements RoleServicePort {

    private final RolePersistencePort rolePersistencePort;
    @Override
    public void save(RoleModel roleModel) {

        rolePersistencePort.save(roleModel);
    }
}