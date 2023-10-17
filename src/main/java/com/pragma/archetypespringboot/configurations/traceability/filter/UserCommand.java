package com.pragma.archetypespringboot.configurations.traceability.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCommand {

    String email;

    @JsonProperty("given_name")
    String name;

    @JsonProperty("cognito:groups")
    List<String> userType;

    @JsonProperty("identities")
    List<identity> identity;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class identity {

        @JsonProperty("userId")
        String userId;
    }
}
