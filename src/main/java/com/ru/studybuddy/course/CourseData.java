package com.ru.studybuddy.course;

import java.time.LocalDateTime;
import java.util.UUID;


public interface CourseData {


    UUID getId();

    String getTitle();
    String getDescription();
    String getBody();

    Long studentsCount();

    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
