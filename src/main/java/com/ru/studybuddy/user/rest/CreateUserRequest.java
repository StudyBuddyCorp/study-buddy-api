package com.ru.studybuddy.user.rest;

import com.ru.studybuddy.user.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @NotBlank
    private UserRole role;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String department;
    @NotBlank
    private String specialty;
    @NotBlank
    private UUID group;
}
