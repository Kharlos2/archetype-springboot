package com.pragma.archetypespringboot.user.infrastructure.adapters.persistence;

import com.pragma.archetypespringboot.user.domain.models.RoleModel;
import com.pragma.archetypespringboot.user.domain.models.UserModel;
import com.pragma.archetypespringboot.user.domain.ports.out.RolePersistencePort;
import com.pragma.archetypespringboot.user.domain.ports.out.UserPersistencePort;
import com.pragma.archetypespringboot.user.infrastructure.mappers.RoleEntityMapper;
import com.pragma.archetypespringboot.user.infrastructure.mappers.UserEntityMapper;
import com.pragma.archetypespringboot.user.infrastructure.repositories.postgresql.RoleRepository;
import com.pragma.archetypespringboot.user.infrastructure.repositories.postgresql.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Transactional
@Component
@RequiredArgsConstructor
public class RolePersistenceAdapter implements RolePersistencePort {

    private final RoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;
    @Override
    public void save(RoleModel roleModel) {
        roleRepository.save(roleEntityMapper.modelToEntity(roleModel));
    }
}
