package com.budget.app.controller;

import com.budget.app.dto.AuthenticateResponseDTO;
import com.budget.app.dto.UserRequestDTO;
import com.budget.app.services.IAuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
@AllArgsConstructor
public class AuthenticationController {
    private final IAuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<AuthenticateResponseDTO> authenticate(@RequestBody UserRequestDTO userRequestDTO) {
        String token = authenticationService.authenticate(
                userRequestDTO.getUsername(), userRequestDTO.getPassword()
        );

        return new ResponseEntity<>(new AuthenticateResponseDTO(token), HttpStatus.OK);

    }
}
