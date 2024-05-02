package com.ru.studybuddy.course.rest;

import com.ru.studybuddy.course.Course;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "формат ответа на создание курса")
public class CreateCourseResponse {
    @Schema(description = "сам курс")
    private Course course;
    private int status;
    private String message;

}
