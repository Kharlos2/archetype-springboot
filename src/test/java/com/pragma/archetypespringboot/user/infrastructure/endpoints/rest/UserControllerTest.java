package com.pragma.archetypespringboot.user.infrastructure.endpoints.rest;

import com.pragma.archetypespringboot.user.application.dtos.requests.SaveUserRequest;
import com.pragma.archetypespringboot.user.application.dtos.responses.GenericUserResponse;
import com.pragma.archetypespringboot.user.application.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testSaveUserEndpoint() throws Exception {
        // Configura el comportamiento del servicio mock
        SaveUserRequest request = new SaveUserRequest();
        request.setName("John Doe");
        request.setDocument("1234567890");
        request.setBirthDate("1990-01-01");

        GenericUserResponse expectedResponse = new GenericUserResponse();
        expectedResponse.setName("John Doe");

        when(userService.save(any(SaveUserRequest.class))).thenReturn(expectedResponse);

        // Realiza una solicitud POST simulada
        mockMvc.perform(post("/api/v1/save-user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(expectedResponse.getId()))
                .andExpect(jsonPath("$.name").value(expectedResponse.getName()));
    }
    @Test
    public void testGetUserByIdEndpoint() throws Exception {
        // Configura el comportamiento del servicio mock
        when(userService.getById(1L)).thenReturn(/* respuesta esperada */);

        // Realiza una solicitud GET simulada
        mockMvc.perform(get("/api/v1/get/{idUser}", 1))
                .andExpect(status().isAccepted())
                .andExpect(/* verificar cuerpo de respuesta */);
    }

}