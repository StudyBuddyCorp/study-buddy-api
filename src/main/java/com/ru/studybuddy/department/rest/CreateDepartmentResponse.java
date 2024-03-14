package com.ru.studybuddy.department.rest;

import com.ru.studybuddy.department.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDepartmentResponse {
    private Department department;
    private int status;
    private String message;
}
