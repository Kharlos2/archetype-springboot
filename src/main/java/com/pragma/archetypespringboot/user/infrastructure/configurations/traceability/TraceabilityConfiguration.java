package com.pragma.archetypespringboot.user.infrastructure.configurations.traceability;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

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
        log.info("Finished Method: " + methodName + " Output arguments: " + result.toString());
        log.info("******* End Request *******");
    }



 /*   @Before("allPublicMethods()")
    public void startedMethod(JoinPoint joinPoint) throws Throwable {
        if (HttpRequestContextHolder.isNotNull()) {

            RequestContextDto requestContextDto = HttpRequestContextHolder.getRequestHolder();
            String arguments = Arrays.asList(joinPoint.getArgs())
                    .stream().map(o -> o.toString()).collect(Collectors.joining(" - "));

            TraceabilityDto traceabilityDto = TraceabilityDto
                    .builder()
                    .aplicativo(null)
                    .bodyEntrada(requestContextDto.getBody())
                    .parametrosEntrada(arguments)
                    .idPeticionGeneral(requestContextDto.getIdGeneralRequest())
                    .idPeticion(requestContextDto.getIdRequest())
                    .correoUsuario(requestContextDto.getEmailRequest())
                    .urlEndpoint(requestContextDto.getUrl())
                    .nombreClase(joinPoint.getSourceLocation().getWithinType().getName())
                    .nombreMetodo(joinPoint.getSignature().getName())
                    .accion(TraceabilityType.METHOD_INIT.toString())
                    .microservicio(null)
                    .fechaCreacion(LocalDateTime.now())
                    .ambiente("local")
                    .build();

            logger.info(traceabilityDto.toString());
            logger.info("prueba");

        }
    }
*/
    /*@AfterReturning("allPublicMethods()")
    public void finishedMethod(JoinPoint joinPoint) throws Throwable {
        if (HttpRequestContextoHolder.isNotNull()) {
            RequestContextoDto requestContextoDto = HttpRequestContextoHolder.getRequestHolder();
            String argumentos = Arrays.asList(joinPoint.getArgs())
                    .stream().map(o -> o.toString()).collect(Collectors.joining(" - "));

            TrazabilidadDto trazabilidadDto = TrazabilidadDto
                    .builder()
                    .aplicativo(parametrosAplicacionConfiguration.getNombreAplicacion())
                    .bodyEntrada(requestContextoDto.getBody())
                    .parametrosEntrada(argumentos)
                    .idPeticionGeneral(requestContextoDto.getIdPeticionGeneral())
                    .idPeticion(requestContextoDto.getIdPeticion())
                    .correoUsuario(requestContextoDto.getEmailRequest())
                    .urlEndpoint(requestContextoDto.getUrl())
                    .nombreClase(joinPoint.getSourceLocation().getWithinType().getName())
                    .nombreMetodo(joinPoint.getSignature().getName())
                    .accion(TipoTrazabilidad.METHOD_COMPLETE.toString())
                    .microservicio(parametrosAplicacionConfiguration.getNombreMicroservicio())
                    .fechaCreacion(LocalDateTime.now())
                    .ambiente(environment.getActiveProfiles()[0].toString())
                    .build();

            TrazabilidadRequestContextHolder.addTrazabilidadDto(trazabilidadDto);
        }
    }*/
}
