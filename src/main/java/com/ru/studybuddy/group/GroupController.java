package com.ru.studybuddy.group;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/groups")
@SecurityRequirement(name = "JWT")
public class GroupController {

    private final GroupService service;

    @GetMapping("/get")
    public ResponseEntity<List<GroupIdAndNumber>> get(@RequestParam String department, @RequestParam String specialty) {
        return  ResponseEntity.ok(service.get(department, specialty));
    }
}
