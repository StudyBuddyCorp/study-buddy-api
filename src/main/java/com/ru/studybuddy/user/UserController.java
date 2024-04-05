package com.ru.studybuddy.user;

import com.ru.studybuddy.user.rest.CreateUserRequest;
import com.ru.studybuddy.user.rest.CreateStudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<CreateStudentResponse> create(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(service.createStudent(request));
    }

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
    public ResponseEntity<User> get(@PathVariable UUID id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count(@RequestParam(required = false) UserRole role) {
        return ResponseEntity.ok(service.count(role));
    }
}
