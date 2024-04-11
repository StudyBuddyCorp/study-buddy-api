package com.ru.studybuddy.course;

import com.ru.studybuddy.course.request.MarkdownCreateRequest;

import java.util.UUID;

public interface CourseRepositoryCustom {
    void addStudentToCourse(UUID courseId, UUID studentId);
    void addMarkdownToCourse(UUID courseId, MarkdownCreateRequest request);
    void editMarkdown(UUID courseId, UUID markdownId, MarkdownCreateRequest request);

}
