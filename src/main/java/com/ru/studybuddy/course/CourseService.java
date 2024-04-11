package com.ru.studybuddy.course;

import com.ru.studybuddy.course.exception.CourseNotFoundException;
import com.ru.studybuddy.course.request.CourseEditRequest;
import com.ru.studybuddy.course.request.CreateCourseRequest;
import com.ru.studybuddy.course.response.CreateCourseResponse;
import com.ru.studybuddy.user.User;
import com.ru.studybuddy.user.UserRole;
import com.ru.studybuddy.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final UserService userService;

    public CreateCourseResponse create(CreateCourseRequest request) {
        Course course = repository.save(Course.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build());
        return CreateCourseResponse.builder()
                .course(course)
                .message("Course created")
                .status(200)
                .build();
    }

    public List<CourseData> getAll(String title) {
        if (title != null && !title.isEmpty()) {
            return repository.getCoursesData(title.toLowerCase());
        }
        return repository.getCoursesData();
    }

    public Course getAll(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    public Long count() {
        return repository.count();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public void edit(UUID id, CourseEditRequest request) {

        Course course = getAll(id);
        String title = request.getTitle();
        String description = request.getDescription();
        String body = request.getBody();

        if (title != null && !title.isEmpty()) {
            course.setTitle(title);
        }

        if (description != null && !description.isEmpty()) {
            course.setDescription(description);
        }
        if (body != null && !body.isEmpty()) {
            course.setBody(body);
        }

        course.setUpdatedAt(LocalDateTime.now());

        repository.save(course);
    }

    @Transactional
    public void subscribeStudent(UUID id, UUID studentId) {
        repository.addStudentToCourse(id, studentId);
    }

    @Transactional
    public void subscribeStudents(UUID courseId, UUID groupId) {
        Course course = getAll(courseId);
        List<User> newStudents = userService.getAllByGroupId(groupId);

        List<User> subscribedStudents = newStudents.stream()
                .filter(student -> !course.getStudents().contains(student))
                .toList();

        course.getStudents().addAll(subscribedStudents);
        repository.saveAndFlush(course);
    }

    public CourseData get(UUID id) {
        return repository.getCourseData(id);
    }

    @Transactional
    public Boolean handleCheckCanEdit(UUID courseId, UUID userId) {
        User user = userService.get(userId);

        if (user.getRole() == UserRole.ADMIN) {
            return true;
        }

        Course course = getAll(courseId);

        return course.getTeachers().contains(user);
    }
}
