package com.ru.studybuddy.course;

import com.ru.studybuddy.markdown.Markdown;
import com.ru.studybuddy.course.request.MarkdownCreateRequest;
import com.ru.studybuddy.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.UUID;

public class CourseRepositoryImpl implements CourseRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addStudentToCourse(UUID courseId, UUID studentId) {
        Course course = entityManager.find(Course.class, courseId);
        User student = entityManager.find(User.class, studentId);

        if (!course.getStudents().contains(student)) {
            course.getStudents().add(student);
            course.setUpdatedAt(LocalDateTime.now());
            entityManager.merge(course);
        }
    }

    @Override
    public void addMarkdownToCourse(UUID courseId, MarkdownCreateRequest request) {
        Course course = entityManager.find(Course.class, courseId);
        if (course != null) {
            Markdown markdown = Markdown.builder()
                    .order(request.getOrder())
                    .body(request.getBody())
                    .course(course)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            course.getBody().add(markdown);
            entityManager.merge(markdown);
        }
    }

    @Override
    public void editMarkdown(UUID courseId, UUID markdownId, MarkdownCreateRequest request) {
        Markdown markdown = entityManager.find(Markdown.class, markdownId);
        markdown.setBody(request.getBody());
        markdown.setOrder(request.getOrder());
        markdown.setUpdatedAt(LocalDateTime.now());
        entityManager.merge(markdown);
    }
}
