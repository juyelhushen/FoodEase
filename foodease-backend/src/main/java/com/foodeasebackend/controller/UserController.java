package com.foodeasebackend.controller;

import com.foodeasebackend.Entity.User;
import com.foodeasebackend.payload.AuthResponse;
import com.foodeasebackend.payload.LoginRequest;
import com.foodeasebackend.payload.SignupRequest;
import com.foodeasebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignupRequest request) {
        return userService.signup(request);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody LoginRequest request) {
        return userService.signIn(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws NoSuchElementException {
        User user =  userService.findByUserId(id);
        return ResponseEntity.ok(user);
    }
}
