package com.ru.studybuddy.course;

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
}
