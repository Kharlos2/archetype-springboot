package com.pragma.archetypespringboot.user.infrastructure.repositories.postgresql;

import com.pragma.archetypespringboot.user.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
