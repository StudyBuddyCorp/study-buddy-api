package com.ru.studybuddy.course;

import com.ru.studybuddy.course.request.CourseEditRequest;
import com.ru.studybuddy.course.request.CreateCourseRequest;
import com.ru.studybuddy.course.request.MarkdownChangeRequest;
import com.ru.studybuddy.course.response.CreateCourseResponse;
import com.ru.studybuddy.course.request.MarkdownCreateRequest;
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
        return ResponseEntity.ok(service.get(title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDataWithBody> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getOne(id));
    }


    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.count());
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

    @PatchMapping("/{courseId}/subscribe/student/{studentId}")
    public ResponseEntity<Void> subscribeStudent(@PathVariable UUID id, @PathVariable UUID studentId) {
        service.subscribeStudent(id, studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{courseId}/can-edit/{userId}")
    public ResponseEntity<Boolean> checkEdit(@PathVariable UUID courseId, @PathVariable UUID userId) {
        return ResponseEntity.ok(service.handleCheckCanEdit(courseId, userId));
    }

    @PatchMapping("/{courseId}/markdown/create")
    public ResponseEntity<Void> createMarkdown(@PathVariable UUID courseId, @RequestBody MarkdownCreateRequest request) {
        service.createMarkdown(courseId, request);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{courseId}/markdown/{markdownId}")
    public ResponseEntity<Void> editMarkdown(@PathVariable UUID courseId, @PathVariable UUID markdownId, @RequestBody MarkdownChangeRequest request) {
        service.editMarkdown(courseId, markdownId, request);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/{courseId}/subscribe/group/{groupId}")
    public ResponseEntity<Void> subscribeGroup(@PathVariable UUID courseId, @PathVariable UUID groupId) {
        service.subscribeStudents(courseId, groupId);
        return ResponseEntity.noContent().build();
    }

}
