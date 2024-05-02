package com.ru.studybuddy.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Register Request",description = "формат запроса для регистрации, все поля должны присудствовать!")
public class RegisterRequest {
    private String email;
    private String password;
    @Schema(description = "под name понимается логин")
    private String name;
}