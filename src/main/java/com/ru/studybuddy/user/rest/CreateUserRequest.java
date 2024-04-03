package com.ru.studybuddy.user.rest;

import com.ru.studybuddy.user.UserRole;
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

    private UserRole role;

    private String name;
    private String email;
    private String department;
    private String specialty;
    private UUID group;
}
