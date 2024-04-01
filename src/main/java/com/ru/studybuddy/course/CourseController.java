package com.ru.studybuddy.course;

import com.ru.studybuddy.course.rest.CreateCourseRequest;
import com.ru.studybuddy.course.rest.CreateCourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping("/create")
    public ResponseEntity<CreateCourseResponse> create(@RequestBody CreateCourseRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/get")
    public ResponseEntity<List<CourseData>> get() {
        return  ResponseEntity.ok(service.get());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return  ResponseEntity.ok(service.count());
    }

}
