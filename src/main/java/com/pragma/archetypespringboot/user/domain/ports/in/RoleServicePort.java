package com.pragma.archetypespringboot.user.domain.ports.in;

import com.pragma.archetypespringboot.user.domain.models.RoleModel;
import com.pragma.archetypespringboot.user.domain.models.UserModel;

public interface RoleServicePort {
    void save(RoleModel roleModel);

}
