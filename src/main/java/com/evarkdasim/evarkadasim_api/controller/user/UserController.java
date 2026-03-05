package com.evarkdasim.evarkadasim_api.controller.user;


import com.evarkdasim.evarkadasim_api.dto.request.user.ProfileUpdateRequest;
import com.evarkdasim.evarkadasim_api.dto.response.user.UserResponse;
import com.evarkdasim.evarkadasim_api.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(UserResponse.fromEntity(user));
    }

}
