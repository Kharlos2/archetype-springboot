package com.pragma.archetypespringboot.user.infrastructure.adapters.persistence;

import com.pragma.archetypespringboot.user.domain.models.UserModel;
import com.pragma.archetypespringboot.user.domain.ports.out.UserPersistencePort;
import com.pragma.archetypespringboot.user.infrastructure.mappers.UserEntityMapper;
import com.pragma.archetypespringboot.user.infrastructure.repositories.postgresql.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Transactional
@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public UserModel save(UserModel userModel) {
        return userEntityMapper.entityToModel(userRepository.save(userEntityMapper.modelToEntity(userModel)));
    }

    @Override
    public UserModel getById(Long idUser) {
        return userEntityMapper.entityToModel(userRepository.findById(idUser).orElse(null));
    }
}
