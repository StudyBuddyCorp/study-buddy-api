package com.ru.studybuddy.speciality;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;


import java.util.List;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "JWT")
@RequestMapping("/api/v1/specialties")
public class SpecialtyController {

    private final SpecialtyService service;

    @GetMapping("/get")
    public ResponseEntity<List<Object>> get(@RequestParam String department) {
        return ResponseEntity.ok(service.get(department));
    }
}
