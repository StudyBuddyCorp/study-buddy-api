package com.ru.studybuddy.auth;


import com.ru.studybuddy.user.User;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Hidden
@Schema(name = "Authentication Response",description = "формат ответа авторизации")
public class AuthenticationResponse {
    @Schema(description = "токен пользователя")
    private String token;

    private User user;

}