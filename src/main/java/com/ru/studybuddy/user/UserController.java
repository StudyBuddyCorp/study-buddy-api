package com.ru.studybuddy.user;

import com.ru.studybuddy.user.rest.CreateUserRequest;
import com.ru.studybuddy.user.rest.CreateStudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@SecurityRequirement(name = "JWT")
@Tag(name = "Контроллер пользователей",description = "Используется для запроса ползователей")
public class UserController {

    private final UserService service;
    @Operation(
            summary = "Создание пользователя",
            description = "Позволяет создать пользователя"
    )
    @PostMapping
    public ResponseEntity<CreateStudentResponse> create(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(service.createStudent(request));
    }
    @Operation(
            summary = "Получение пользователей с линкером",
            description = "Получение пользователей с линкером для возможности дальнейшей сортировки"
    )
    @GetMapping
    public ResponseEntity<RepresentationModel<UserDto>> getAll(
            @RequestParam(required = false) UserRole role,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String specialty,
            @RequestParam(required = false) UUID groupId) {
        return ResponseEntity.ok(service.getAll(role, name, department, specialty, groupId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UserDto>> get(@PathVariable UUID id) {
        return ResponseEntity.ok(service.one(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count(@RequestParam(required = false) UserRole role) {
        return ResponseEntity.ok(service.count(role));
    }
}
