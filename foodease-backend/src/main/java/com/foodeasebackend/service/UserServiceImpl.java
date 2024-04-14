package com.foodeasebackend.service;

import com.foodeasebackend.Entity.Cart;
import com.foodeasebackend.Entity.Role;
import com.foodeasebackend.Entity.User;
import com.foodeasebackend.custome.UserDetailsServiceImp;
import com.foodeasebackend.jwt.AuthFilter;
import com.foodeasebackend.jwt.JwtUtils;
import com.foodeasebackend.payload.AuthResponse;
import com.foodeasebackend.payload.LoginRequest;
import com.foodeasebackend.payload.SignupRequest;
import com.foodeasebackend.repository.CartRepository;
import com.foodeasebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImp userDetailsService;
    private final AuthFilter authFilter;
    private final CartRepository cartRepository;


    @Override
    public ResponseEntity<AuthResponse> signup(SignupRequest request) {
        AuthResponse response = new AuthResponse();
        if (signUpValidate(request)) {
            User user = userRepository.findByEmail(request.getEmail());
            if (user != null) throw new IllegalArgumentException("Email is already user with another account");
            User savedUser = userRepository.save(register(request));

            Cart cart = new Cart();
            cart.setCustomer(savedUser);
            cartRepository.save(cart);

            Authentication auth = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
            SecurityContextHolder.getContext().setAuthentication(auth);

            String jwtToken = jwtUtils.generate(savedUser.getEmail(), savedUser.getRole());
            response.setToken(jwtToken);
            response.setRole(savedUser.getRole().toString());
            response.setMessage("SignUp successful");
        }
        return ResponseEntity.ok(response);
    }


    private User register(SignupRequest request) {
        return User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.Customer)
                .build();
    }

    private boolean signUpValidate(SignupRequest request) {
        return request.getFullName() != null &&
                request.getEmail() != null &&
                request.getPassword() != null;
    }


    @Override
    public ResponseEntity<AuthResponse> signIn(LoginRequest request) {
        try {
            AuthResponse response = new AuthResponse();
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getEmail(), request.getPassword()
                            )
                    );

            if (authenticate.isAuthenticated()) {
                User user = userRepository.findByEmail(request.getEmail());
                SecurityContextHolder.getContext().setAuthentication(authenticate);
                String token = jwtUtils.generate(user.getEmail(), user.getRole());
                response.setToken(token);
                response.setRole(user.getRole().toString());
                response.setMessage("Login success");
            }
            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
