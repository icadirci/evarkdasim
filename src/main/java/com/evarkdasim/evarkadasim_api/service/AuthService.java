package com.evarkdasim.evarkadasim_api.service;

import com.evarkdasim.evarkadasim_api.dto.request.auth.RegisterRequest;
import com.evarkdasim.evarkadasim_api.dto.response.auth.RegisterResponse;
import com.evarkdasim.evarkadasim_api.entity.User;
import com.evarkdasim.evarkadasim_api.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

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
}
