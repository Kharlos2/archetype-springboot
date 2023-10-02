package com.pragma.archetypespringboot.user.infrastructure.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"com.pragma.archetypespringboot.user.domain.usecases", "com.pragma.archetypespringboot.user.infrastructure.adapters.persistence"})
public class BeanConfiguration {

}
