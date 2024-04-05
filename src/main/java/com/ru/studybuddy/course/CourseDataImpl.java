package com.ru.studybuddy.course;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public class CourseDataImpl implements CourseData{

    private UUID id;

    private String title;

    private String description;

    private Long studentsCount;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime createdAt;
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime updatedAt;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

//    @Override
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    @Override
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Long getStudentsCount() {
        return studentsCount;
    }
}
