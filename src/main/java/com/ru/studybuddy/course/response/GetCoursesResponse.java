package com.ru.studybuddy.course.response;

import com.ru.studybuddy.course.CourseData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCoursesResponse {
    private List<CourseData> courses;
    private int status;
    private String message;
}
