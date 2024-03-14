package com.ru.studybuddy.speciality;

import com.ru.studybuddy.speciality.requests.CreateSpecialityRequest;
import com.ru.studybuddy.speciality.responses.CreateSpecialityResponse;
import com.ru.studybuddy.speciality.responses.GetSpecialitiesResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialityService {

    private final SpecialityRepository repository;

    public CreateSpecialityResponse create(CreateSpecialityRequest request) {
        Speciality speciality = repository.save(Speciality.builder().title(request.getTitle()).build());
        return CreateSpecialityResponse.builder()
                .message("Speciality created")
                .status(200)
                .speciality(speciality)
                .build();
    }

    public GetSpecialitiesResponse get() {
        List<Speciality> specialties = repository.findAll();
        return GetSpecialitiesResponse.builder()
                .message("Specialities found")
                .status(200)
                .specialties(specialties)
                .build();
    }
    public Speciality findByTitle(String title) {
        return repository.findByTitle(title)
                .orElseThrow(() -> new EntityNotFoundException("Speciality with title: " + title + " not found"));
    }
}
