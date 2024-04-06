package com.ru.studybuddy.course;

import java.time.LocalDateTime;
import java.util.UUID;

public class CourseDataImpl implements CourseData{


    public CourseDataImpl(UUID id, String title, String description, LocalDateTime createdAt, LocalDateTime updatedAt, Long studentsCount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.studentsCount = studentsCount;
    }

    private UUID id;
    private String title;
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long studentsCount;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Long getStudentsCount() {
        return studentsCount;
    }
}
