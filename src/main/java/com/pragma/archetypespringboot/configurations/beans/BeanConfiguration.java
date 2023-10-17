package com.pragma.archetypespringboot.configurations.beans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(BeanImportSelector.class)
public class BeanConfiguration {


}
