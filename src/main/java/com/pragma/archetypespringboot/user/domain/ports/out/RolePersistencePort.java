package com.pragma.archetypespringboot.user.domain.ports.out;

import com.pragma.archetypespringboot.user.domain.models.RoleModel;
import com.pragma.archetypespringboot.user.domain.models.UserModel;

public interface RolePersistencePort {
    void save(RoleModel roleModel);
}
