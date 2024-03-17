package com.ru.studybuddy.speciality.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSpecialitiesResponse {

    private String message;
    private int status;
    private List<Object> specialties;
}
