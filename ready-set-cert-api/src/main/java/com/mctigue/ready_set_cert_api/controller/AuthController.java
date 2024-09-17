package com.mctigue.ready_set_cert_api.controller;

import com.mctigue.ready_set_cert_api.service.TokenService;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
        return authentication.getCredentials().toString();
        //return tokenService.generateToken(authentication);
    }
}
