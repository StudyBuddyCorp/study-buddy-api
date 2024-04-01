package com.ru.studybuddy.course.exception;

import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

public class CourseNotFoundException extends EntityNotFoundException {
    public CourseNotFoundException(UUID id) {
        super(id.toString());
    }
}
