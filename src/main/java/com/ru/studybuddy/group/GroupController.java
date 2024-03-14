package com.ru.studybuddy.group;

import com.ru.studybuddy.group.responses.GetGroupResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/groups")
public class GroupController {

    private final GroupService service;

    @GetMapping("/get")
    public ResponseEntity<GetGroupResponse> get(@RequestParam String department, @RequestParam String specialty) {
        return  ResponseEntity.ok(service.get(department, specialty));
    }
}
