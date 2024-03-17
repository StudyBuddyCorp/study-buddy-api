package com.ru.studybuddy.speciality;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialtyService {

    private final SpecialtyRepository repository;

    public List<Object> get(String department) {
        return repository.findByDepartment_TitleOrderByTitleAsc(department);
    }
    public Specialty getByTitle(String title) {
        return repository.findByTitle(title)
                .orElseThrow(() -> new EntityNotFoundException("Specialty with title: " + title + " not found"));
    }
}
