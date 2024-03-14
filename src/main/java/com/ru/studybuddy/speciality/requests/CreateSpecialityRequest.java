package com.ru.studybuddy.speciality.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateSpecialityRequest {
    private String title;
}
