package com.ru.studybuddy.department.rest;

import com.ru.studybuddy.department.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetDepartmentResponse {
    private List<Department> departments;
    private int status;
    private String message;
}
