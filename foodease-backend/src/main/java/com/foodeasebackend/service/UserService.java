package com.foodeasebackend.service;

import com.foodeasebackend.payload.AuthResponse;
import com.foodeasebackend.payload.LoginRequest;
import com.foodeasebackend.payload.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<AuthResponse> signup(SignupRequest request);

    ResponseEntity<AuthResponse> signIn(LoginRequest request);
}
