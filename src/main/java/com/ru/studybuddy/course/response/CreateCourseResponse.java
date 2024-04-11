package com.ru.studybuddy.course.response;

import com.ru.studybuddy.course.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCourseResponse {
    private Course course;
    private int status;
    private String message;

}
