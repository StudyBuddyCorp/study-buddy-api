package com.ru.studybuddy.course;

import com.ru.studybuddy.course.rest.CreateCourseRequest;
import com.ru.studybuddy.course.rest.CreateCourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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

    public List<CourseTitleAndDescription> get() {
        return repository.findByOrderByTitleAsc(Pageable.ofSize(25));
    }
}
