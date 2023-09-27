package com.pragma.archetypespringboot.user.infrastructure.endpoints.rest;

import com.pragma.archetypespringboot.user.application.dtos.responses.GenericUserResponse;
import com.pragma.archetypespringboot.user.application.services.GetUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GetUserController {


    private final GetUserService getUserService;

    @GetMapping("/get")
    public ResponseEntity<GenericUserResponse> getUserById(@RequestParam Long idUser) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(getUserService.getUserById(idUser));
    }


}
