package com.ru.studybuddy.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Авторизация",description = "Авторизация пользователей,доступна без токена")
public class AuthenticationController {

    private final AuthenticationService service;

    @Operation(
            summary = "Регистрация пользователя",
            description = "Позволяет зарегестрировать пользоватедя"
    )
    @PostMapping("/registration")
    public ResponseEntity<AuthenticationResponse> registration(@RequestBody RegisterRequest request, HttpServletResponse httpServletResponse) {
        return ResponseEntity.ok(service.registration(request, httpServletResponse));
    }
    @Operation(
            summary = "Авторизация пользователя",
            description = "Позволяет авторизировать пользователя"
    )
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request, HttpServletResponse httpServletResponse) {
        return ResponseEntity.ok(service.login(request, httpServletResponse));
    }
    @Operation(
            summary = "Обновления токена",
            description = "Позволяет обновить токен для пользователя"
    )

    @GetMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refresh(@CookieValue("token") String refreshToken, HttpServletResponse httpServletResponse) {
        return ResponseEntity.ok(service.refresh(refreshToken, httpServletResponse));
    }
    @Operation(
            summary = "Удалить токен",
            description = "Удаляет переданный токен"
    )
    @DeleteMapping("/logout")
    public ResponseEntity<Object> logout(@CookieValue("token") String refreshToken) {
        service.logout(refreshToken);
        return ResponseEntity.noContent().build();
    }

}