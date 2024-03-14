package com.ru.studybuddy.speciality.responses;

import com.ru.studybuddy.speciality.Speciality;
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
    private List<Speciality> specialties;
}
