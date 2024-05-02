package com.ru.studybuddy.course.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "формат изменения курса")
public class CourseEditRequest {
    private String title;
    private String description;
}
