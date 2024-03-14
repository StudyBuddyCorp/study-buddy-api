package com.ru.studybuddy.group;

import com.ru.studybuddy.group.responses.GetGroupResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository repository;

    public GetGroupResponse get(String department, String speciality) {
        List<Group> groups = repository.findAll();
        if (department != null) {
            groups = groups.stream().filter(group -> group.getDepartment().getTitle().equals(department)).toList();
        }
        if (speciality != null) {
            groups = groups.stream().filter(group -> group.getSpecialty().getTitle().equals(speciality)).toList();
        }
        return GetGroupResponse.builder()
                .groups(groups)
                .message("Groups found and filtered")
                .status(200)
                .build();
    }

    public Group findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Speciality with id: " + id + " not found"));
    }
}
