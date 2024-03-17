package com.ru.studybuddy.user;

import com.ru.studybuddy.user.rest.CreateStudentRequest;
import com.ru.studybuddy.user.rest.CreateStudentResponse;
import com.ru.studybuddy.user.rest.GetStudentsResponse;
import lombok.RequiredArgsConstructor;
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
        return  ResponseEntity.ok(service.createStudent(request));
    }

    @GetMapping("/get-students")
    public ResponseEntity<GetStudentsResponse> getStudents(@RequestParam String name, @RequestParam String department, @RequestParam String specialty, @RequestParam String group) {
        return ResponseEntity.ok(service.getStudents(name, department, specialty,group));
    }
}
