package com.foodeasebackend.service;

import com.foodeasebackend.Entity.User;
import com.foodeasebackend.payload.AuthResponse;
import com.foodeasebackend.payload.LoginRequest;
import com.foodeasebackend.payload.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.NoSuchElementException;

public interface UserService {

    ResponseEntity<AuthResponse> signup(SignupRequest request);

    ResponseEntity<AuthResponse> signIn(LoginRequest request);

    User findByUserId(Long userId) throws NoSuchElementException;
}
