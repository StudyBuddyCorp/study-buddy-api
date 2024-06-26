package com.ru.studybuddy.course;

import com.ru.studybuddy.course.request.CourseEditRequest;
import com.ru.studybuddy.course.rest.CreateCourseRequest;
import com.ru.studybuddy.course.rest.CreateCourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping
    public ResponseEntity<CreateCourseResponse> create(@RequestBody CreateCourseRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<CourseData>> get(@RequestParam(required = false) String title) {
        return  ResponseEntity.ok(service.get(title));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CourseData> getOne(@PathVariable UUID id) {
        return  ResponseEntity.ok(service.getOneCache(id));
    }


    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return  ResponseEntity.ok(service.count());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> edit(@PathVariable UUID id, @RequestBody CourseEditRequest request) {
        service.edit(id, request);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/subscribe/student/{studentId}")
    public ResponseEntity<Void> subscribeStudent(@PathVariable UUID id, @PathVariable UUID studentId) {
        service.subscribeStudent(id, studentId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/subscribe/group/{groupId}")
    public ResponseEntity<Void> subscribeGroup(@PathVariable UUID courseId, @PathVariable UUID groupId) {
        service.subscribeStudents(courseId, groupId);
        return ResponseEntity.noContent().build();
    }

}
