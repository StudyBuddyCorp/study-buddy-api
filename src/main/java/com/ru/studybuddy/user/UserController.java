package com.ru.studybuddy.user;

import com.ru.studybuddy.user.rest.CreateStudentRequest;
import com.ru.studybuddy.user.rest.CreateStudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponse> createStudent(@RequestBody CreateStudentRequest request) {
        return ResponseEntity.ok(service.createStudent(request));
    }

    @GetMapping("/get-students")
    public ResponseEntity<RepresentationModel<UserDto>> getStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String specialty,
            @RequestParam(required = false) UUID groupId) {
        return ResponseEntity.ok(service.allStudents(name, department, specialty, groupId));
    }
    @GetMapping("/one")
    public ResponseEntity<EntityModel<UserDto>> one(@PathVariable  UUID id) {
        return ResponseEntity.ok(service.one(id));
    }

}
