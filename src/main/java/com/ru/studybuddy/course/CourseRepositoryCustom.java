package com.ru.studybuddy.course;

import java.util.UUID;

public interface CourseRepositoryCustom {
    void addStudentToCourse(UUID courseId, UUID studentId);

}
