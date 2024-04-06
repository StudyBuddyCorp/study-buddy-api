package com.ru.studybuddy.course;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public interface CourseData extends Serializable {

    UUID getId();

    String getTitle();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime getCreatedAt();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")

    LocalDateTime getUpdatedAt();

    String getDescription();

    Long getStudentsCount();
}
