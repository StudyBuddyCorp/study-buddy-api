package com.ru.studybuddy.department.rest;

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
    private List<Object> departments;
    private int status;
    private String message;
}
