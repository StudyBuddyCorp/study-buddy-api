package com.ru.studybuddy.department;

import com.ru.studybuddy.department.rest.CreateDepartmentRequest;
import com.ru.studybuddy.department.rest.CreateDepartmentResponse;
import com.ru.studybuddy.department.rest.GetDepartmentResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;

    public CreateDepartmentResponse create(CreateDepartmentRequest request) {
        Department department= repository.save(Department.builder().title(request.getTitle()).build());
        return CreateDepartmentResponse.builder().department(department).build();
    }

    public GetDepartmentResponse get() {
        List<Object> departments = repository.findAllOrderByTitleAsc();
        return GetDepartmentResponse.builder()
                .departments(departments)
                .message("Departments found")
                .status(200)
                .build();
    }
    public Department findByTitle(String title) {
        return repository.findByTitle(title)
                .orElseThrow(() -> new EntityNotFoundException("Department with title: " + title + " not found"));
    }
}
