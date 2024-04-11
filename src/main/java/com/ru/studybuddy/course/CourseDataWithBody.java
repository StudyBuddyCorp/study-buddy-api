package com.ru.studybuddy.course;

import com.ru.studybuddy.markdown.Markdown;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface CourseDataWithBody {
    UUID getId();
    String getTitle();
    List<Markdown> getBody();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
    String getDescription();
}
