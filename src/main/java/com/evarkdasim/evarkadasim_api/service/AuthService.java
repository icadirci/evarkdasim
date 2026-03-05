package com.evarkdasim.evarkadasim_api.service;

import com.evarkdasim.evarkadasim_api.dto.request.auth.LoginRequest;
import com.evarkdasim.evarkadasim_api.dto.request.auth.RegisterRequest;
import com.evarkdasim.evarkadasim_api.dto.response.auth.LoginResponse;
import com.evarkdasim.evarkadasim_api.dto.response.auth.RegisterResponse;
import com.evarkdasim.evarkadasim_api.entity.User;
import com.evarkdasim.evarkadasim_api.repository.UserRepository;
import com.evarkdasim.evarkadasim_api.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public RegisterResponse register(RegisterRequest registerRequest){
        Boolean emailExist = userRepository.existsByEmail(registerRequest.email());
        if (emailExist){
            throw new RuntimeException("Email is already exists");
        }
        String encodedPassword = passwordEncoder.encode(registerRequest.password());
        User user = new User();
        user.setEmail(registerRequest.email());
        user.setFullName(registerRequest.name());
        user.setPassword(encodedPassword);
        user.setGender(registerRequest.gender());
        User newUser = userRepository.save(user);
        return new RegisterResponse(
                newUser.getFullName(),
                newUser.getEmail()
        );
    }

    public LoginResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.email(),
                        loginRequest.password()
                )
        );
        User user = userRepository.findByEmail(loginRequest.email())
                .orElseThrow();

        String jwtToken = jwtService.generateToken(user);
        return new LoginResponse(user.getId(), user.getEmail(), jwtToken);

    }
}
