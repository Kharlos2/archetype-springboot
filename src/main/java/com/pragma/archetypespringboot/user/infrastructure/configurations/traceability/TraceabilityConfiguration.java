package com.pragma.archetypespringboot.user.infrastructure.configurations.traceability;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Log4j2
@ConditionalOnProperty(
        value = "spring.enabled.traceability.allMethods",
        havingValue = "true",
        matchIfMissing = true
)
@RequiredArgsConstructor
public class TraceabilityConfiguration {

    private final ParametersApplicationConfiguration parametersApplicationConfiguration;
    private final Environment environment;

    @Pointcut("within(com.pragma.archetypespringboot.user.application.services.impl.*) || within(com.pragma.archetypespringboot.user.domain.usecases.*)")
    public void allPublicMethods() {

    }
    @Before("allPublicMethods()")
    public void startedMethod(JoinPoint joinPoint) throws Throwable {
        if (HttpRequestContextHolder.isNotNull()) {

            RequestContextDto requestContextDto = HttpRequestContextHolder.getRequestHolder();
            String arguments = Arrays.asList(joinPoint.getArgs())
                    .stream().map(o -> o.toString()).collect(Collectors.joining(" - "));

            TraceabilityDto traceabilityDto = TraceabilityDto
                    .builder()
                    .application(parametersApplicationConfiguration.getApplicationName())
                    .inputBody(requestContextDto.getBody())
                    .inputParameters(arguments)
                    .GeneralRequestId(requestContextDto.getIdGeneralRequest())
                    .requestId(requestContextDto.getIdRequest())
                    .emailUser(requestContextDto.getEmailRequest())
                    .urlEndpoint(requestContextDto.getUrl())
                    .className(joinPoint.getSourceLocation().getWithinType().getName())
                    .methodName(joinPoint.getSignature().getName())
                    .action(TraceabilityType.METHOD_INIT.toString())
                    .microservice(parametersApplicationConfiguration.getMicroserviceName())
                    .creationDate(LocalDateTime.now())
                    .environment(environment.getActiveProfiles()[0].toString())
                    .build();
            log.info(traceabilityDto.toString());
        }
    }
    @AfterReturning("allPublicMethods()")
    public void finishedMethod(JoinPoint joinPoint) throws Throwable {
        if (HttpRequestContextHolder.isNotNull()) {
            RequestContextDto requestContextDto = HttpRequestContextHolder.getRequestHolder();
            String arguments = Arrays.asList(joinPoint.getArgs())
                    .stream().map(o -> o.toString()).collect(Collectors.joining(" - "));

            TraceabilityDto traceabilityDto = TraceabilityDto
                    .builder()
                    .application(parametersApplicationConfiguration.getApplicationName())
                    .inputBody(requestContextDto.getBody())
                    .inputParameters(arguments)
                    .GeneralRequestId(requestContextDto.getIdGeneralRequest())
                    .requestId(requestContextDto.getIdRequest())
                    .emailUser(requestContextDto.getEmailRequest())
                    .urlEndpoint(requestContextDto.getUrl())
                    .className(joinPoint.getSourceLocation().getWithinType().getName())
                    .methodName(joinPoint.getSignature().getName())
                    .action(TraceabilityType.METHOD_COMPLETE.toString())
                    .microservice(parametersApplicationConfiguration.getMicroserviceName())
                    .creationDate(LocalDateTime.now())
                    .environment(environment.getActiveProfiles()[0].toString())
                    .build();
            log.info(traceabilityDto.toString());
        }
    }
}
