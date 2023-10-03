package com.pragma.archetypespringboot.user.infrastructure.configurations.traceability;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
public class TraceabilityConfiguration {

    @Pointcut("within(com.pragma.archetypespringboot.user.application.services.impl.*) || within(com.pragma.archetypespringboot.user.domain.usecases.*)")
    public void allPublicMethods() {

    }
/*
    @Before("allPublicMethods()")
    public void startedMethod(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().toShortString();
        String arguments = Arrays.toString(joinPoint.getArgs());

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String metodoHttp = request.getMethod();

        log.info("******* Start Request *******");
        log.info("Started method: " + methodName + " with arguments: " + arguments + " HTTP Method: " + metodoHttp);
    }
    @AfterReturning(pointcut = "allPublicMethods()", returning = "result")
    public void finishedMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        if (result != null) {
            log.info("Finished Method: " + methodName + " Output arguments: " + result.toString());
        } else {
            log.info("Finished Method: " + methodName + " Output arguments: null");
        }

        log.info("******* End Request *******");
    }
*/



    @Before("allPublicMethods()")
    public void startedMethod(JoinPoint joinPoint) throws Throwable {
        if (HttpRequestContextHolder.isNotNull()) {

            RequestContextDto requestContextDto = HttpRequestContextHolder.getRequestHolder();
            String arguments = Arrays.asList(joinPoint.getArgs())
                    .stream().map(o -> o.toString()).collect(Collectors.joining(" - "));

            TraceabilityDto traceabilityDto = TraceabilityDto
                    .builder()
                    .application(null)
                    .inputBody(requestContextDto.getBody())
                    .inputParameters(arguments)
                    .GeneralRequestId(requestContextDto.getIdGeneralRequest())
                    .requestId(requestContextDto.getIdRequest())
                    .emailUser(requestContextDto.getEmailRequest())
                    .urlEndpoint(requestContextDto.getUrl())
                    .className(joinPoint.getSourceLocation().getWithinType().getName())
                    .methodName(joinPoint.getSignature().getName())
                    .action(TraceabilityType.METHOD_INIT.toString())
                    .microservice(null)
                    .creationDate(LocalDateTime.now())
                    .environment("local")
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
                    .application(null)
                    .inputBody(requestContextDto.getBody())
                    .inputParameters(arguments)
                    .GeneralRequestId(requestContextDto.getIdGeneralRequest())
                    .requestId(requestContextDto.getIdRequest())
                    .emailUser(requestContextDto.getEmailRequest())
                    .urlEndpoint(requestContextDto.getUrl())
                    .className(joinPoint.getSourceLocation().getWithinType().getName())
                    .methodName(joinPoint.getSignature().getName())
                    .action(TraceabilityType.METHOD_COMPLETE.toString())
                    .microservice(null)
                    .creationDate(LocalDateTime.now())
                    .environment("local")
                    .build();
            log.info(traceabilityDto.toString());
        }
    }
}
