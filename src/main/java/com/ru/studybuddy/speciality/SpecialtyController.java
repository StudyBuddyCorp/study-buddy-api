package com.ru.studybuddy.speciality;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/specialties")
public class SpecialtyController {

    private final SpecialtyService service;

    @GetMapping("/get")
    public ResponseEntity<List<Object>> get(@RequestParam String department) {
        return ResponseEntity.ok(service.get(department));
    }
}
