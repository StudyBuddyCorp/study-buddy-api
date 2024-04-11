package com.ru.studybuddy.course.request;

import lombok.Data;


@Data
public class MarkdownCreateRequest {

    private String body;
    private int order;
}
