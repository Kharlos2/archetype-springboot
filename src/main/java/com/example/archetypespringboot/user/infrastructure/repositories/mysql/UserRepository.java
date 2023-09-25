package com.example.archetypespringboot.user.infrastructure.repositories.mysql;

import com.example.archetypespringboot.user.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
