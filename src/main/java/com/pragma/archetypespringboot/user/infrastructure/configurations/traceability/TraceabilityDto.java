package com.pragma.archetypespringboot.user.infrastructure.configurations.traceability;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TraceabilityDto {

    private String application;

    @JsonProperty("input_body")
    private String inputBody;

    @JsonProperty("parametros_entrada")
    private String inputParameters;

    @JsonProperty("id_peticion_general")
    private String GeneralRequestId;

    @JsonProperty("id_peticion")
    private String requestId;

    @JsonProperty("correo_usuario")
    private String emailUser;

    @JsonProperty("url_endpoint")
    private String urlEndpoint;

    @JsonProperty("nombre_clase")
    private String className;

    @JsonProperty("nombre_metodo")
    private String methodName;

    private String action;

    private String microservice;

    @JsonProperty("traza_error")
    private String traceError;

    @JsonProperty("fecha_creacion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd HH:mm:ss .SSS")
    private LocalDateTime creationDate;


    @JsonProperty("ambiente")
    private String environment;

    public String toString() {
        return "TraceabilityDto{" +
                "application='" + application + '\'' +
                ", inputBody='" + inputBody + '\'' +
                ", inputParameters='" + inputParameters + '\'' +
                ", GeneralRequestId='" + GeneralRequestId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", emailUser='" + emailUser + '\'' +
                ", urlEndpoint='" + urlEndpoint + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", action='" + action + '\'' +
                ", microservice='" + microservice + '\'' +
                ", creationDate=" + creationDate +
                ", environment='" + environment + '\'' +
                '}';
    }

}
