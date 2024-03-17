package com.ru.studybuddy.course.rest;

import com.ru.studybuddy.course.CourseTitleAndDescription;
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
    private List<CourseTitleAndDescription> courses;
    private int status;
    private String message;
}
