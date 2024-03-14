package com.ru.studybuddy.course;

import com.ru.studybuddy.course.rest.CreateCourseRequest;
import com.ru.studybuddy.course.rest.CreateCourseResponse;
import com.ru.studybuddy.course.rest.GetCoursesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    public CreateCourseResponse create(CreateCourseRequest request) {
        Course course = repository.save(Course.builder().title(request.getTitle()).description(request.getDescription()).build());
        return CreateCourseResponse.builder()
                .course(course)
                .message("Course created")
                .status(200)
                .build();
    }

    public GetCoursesResponse get() {
        List<Course> courses = repository.findAll();
        return GetCoursesResponse.builder()
                .courses(courses)
                .message("Courses found")
                .status(200)
                .build();
    }
}
