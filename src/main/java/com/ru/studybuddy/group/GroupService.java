package com.ru.studybuddy.group;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository repository;

    public List<GroupIdAndNumber> get(String department, String speciality) {
        return repository.findByDepartment_TitleAndSpecialty_Title(department, speciality);
    }

    public Group findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Specialty with id: " + id + " not found"));
    }
}
