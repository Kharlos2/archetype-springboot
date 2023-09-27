package com.pragma.archetypespringboot.user.infrastructure.configurations;

import com.pragma.archetypespringboot.user.domain.usecases.GetUserUseCase;
import com.pragma.archetypespringboot.user.domain.usecases.SaveUserUseCase;
import com.pragma.archetypespringboot.user.infrastructure.adapters.persistence.UserPersistenceAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({UserPersistenceAdapter.class, SaveUserUseCase.class, GetUserUseCase.class})
public class BeanConfiguration {

}
