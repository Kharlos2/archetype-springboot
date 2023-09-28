package com.pragma.archetypespringboot.user.infrastructure.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD


@Configuration
@ComponentScan({"com.pragma.archetypespringboot.user.domain.usecases", "com.pragma.archetypespringboot.user.infrastructure.adapters.persistence"})
=======

@Configuration
@ComponentScan(basePackages = "com.pragma.archetypespringboot.user")
>>>>>>> b8ea66b (Bean now with ComponentScan)
public class BeanConfiguration {

}
