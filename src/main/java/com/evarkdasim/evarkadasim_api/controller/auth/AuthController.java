package com.evarkdasim.evarkadasim_api.controller.auth;

import com.evarkdasim.evarkadasim_api.dto.request.auth.LoginRequest;
import com.evarkdasim.evarkadasim_api.dto.request.auth.RegisterRequest;
import com.evarkdasim.evarkadasim_api.dto.response.auth.LoginResponse;
import com.evarkdasim.evarkadasim_api.dto.response.auth.RegisterResponse;
import com.evarkdasim.evarkadasim_api.entity.User;
import com.evarkdasim.evarkadasim_api.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest registerRequest){
        RegisterResponse response = authService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse response = authService.login(loginRequest);
        return ResponseEntity.ok().body(response);
    }


}
