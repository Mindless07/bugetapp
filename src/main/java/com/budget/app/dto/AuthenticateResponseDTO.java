package com.budget.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticateResponseDTO  {
    private String token;
}
