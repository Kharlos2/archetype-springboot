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

    private String aplicativo;

    @JsonProperty("body_entrada")
    private String bodyEntrada;

    @JsonProperty("parametros_entrada")
    private String parametrosEntrada;

    @JsonProperty("id_peticion_general")
    private String idPeticionGeneral;

    @JsonProperty("id_peticion")
    private String idPeticion;

    @JsonProperty("correo_usuario")
    private String correoUsuario;

    @JsonProperty("url_endpoint")
    private String urlEndpoint;

    @JsonProperty("nombre_clase")
    private String nombreClase;

    @JsonProperty("nombre_metodo")
    private String nombreMetodo;

    private String accion;

    private String microservicio;

    @JsonProperty("traza_error")
    private String trazaError;

    @JsonProperty("fecha_creacion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd HH:mm:ss .SSS")
    private LocalDateTime fechaCreacion;


    @JsonProperty("ambiente")
    private String ambiente;
}
