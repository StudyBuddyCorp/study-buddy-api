package com.ru.studybuddy.course;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonDeserialize(as = CourseDataImpl.class)
public interface CourseData extends Serializable {
    UUID getId();
    String getTitle();

    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
    String getDescription();
    Long getStudentsCount();
}
