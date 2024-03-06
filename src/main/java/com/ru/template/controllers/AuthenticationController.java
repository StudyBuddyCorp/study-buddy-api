package com.ru.template.controllers;

import com.ru.template.entities.auth.AuthenticationRequest;
import com.ru.template.entities.auth.AuthenticationResponse;
import com.ru.template.entities.auth.RegisterRequest;
import com.ru.template.services.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/registration")
    public ResponseEntity<AuthenticationResponse> registration(@RequestBody RegisterRequest request, HttpServletResponse httpServletResponse) {
        return ResponseEntity.ok(service.registration(request, httpServletResponse));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request, HttpServletResponse httpServletResponse) {
        return ResponseEntity.ok(service.login(request, httpServletResponse));
    }

    @GetMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refresh(@CookieValue("refreshToken") String refreshToken, HttpServletResponse httpServletResponse) {
        return ResponseEntity.ok(service.refresh(refreshToken, httpServletResponse));
    }

    @DeleteMapping("/logout")
    public void logout(@CookieValue("refreshToken") String refreshToken) {
        service.logout(refreshToken);
    }
}