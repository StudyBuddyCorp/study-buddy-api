package com.ru.studybuddy.department;

import com.ru.studybuddy.department.rest.CreateDepartmentRequest;
import com.ru.studybuddy.department.rest.CreateDepartmentResponse;
import com.ru.studybuddy.department.rest.GetDepartmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping("/create")
    public ResponseEntity<CreateDepartmentResponse> create(@RequestBody CreateDepartmentRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/get")
    public ResponseEntity<GetDepartmentResponse> get() {
        return ResponseEntity.ok(service.get());
    }
}
