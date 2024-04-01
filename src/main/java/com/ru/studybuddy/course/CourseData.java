package com.ru.studybuddy.course;

import java.time.LocalDateTime;
import java.util.UUID;

public interface CourseData {
    UUID getId();
    String getTitle();

    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
    String getDescription();
    Long getStudentsCount();
}
