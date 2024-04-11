package com.ru.studybuddy.course.request;

import lombok.Data;

@Data
public class CourseEditRequest {
    private String title;
    private String description;
    private String body;
}
