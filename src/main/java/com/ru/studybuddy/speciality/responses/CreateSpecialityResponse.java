package com.ru.studybuddy.speciality.responses;

import com.ru.studybuddy.speciality.Speciality;
import lombok.Builder;

@Builder
public class CreateSpecialityResponse {
    private String message;
    private int status;
    private Speciality speciality;

}
