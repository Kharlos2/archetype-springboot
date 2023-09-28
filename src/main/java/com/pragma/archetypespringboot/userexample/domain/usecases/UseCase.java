package com.pragma.archetypespringboot.userexample.domain.usecases;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UseCase {

  String staticName() default "";

  AnyAnnotation[] onConstructor() default {};

  AccessLevel access() default AccessLevel.PUBLIC;

  // Define la anotación interna AnyAnnotation
  @Retention(RetentionPolicy.SOURCE)
  @Target({})
  @interface AnyAnnotation {
  }

}
