package com.ru.studybuddy.user.rest;

import com.ru.studybuddy.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class GetStudentsResponse {

    private final String message;
    private final int status;
    private final List<User> students;
}
