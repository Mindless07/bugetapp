package com.budget.app.controller;

import com.budget.app.dto.UserRequestDTO;
import com.budget.app.services.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
    @Autowired
    IAuthenticationService authenticationService;

    @PostMapping
    public String authenticate(@RequestBody UserRequestDTO userRequestDTO) throws Exception {

        return authenticationService.authenticate(
                userRequestDTO.getUsername(), userRequestDTO.getPassword()
        );


    }
}
