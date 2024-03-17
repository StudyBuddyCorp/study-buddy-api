package com.ru.studybuddy.user;


import com.ru.studybuddy.auth.RegisterRequest;
import com.ru.studybuddy.department.Department;
import com.ru.studybuddy.department.DepartmentService;
import com.ru.studybuddy.group.Group;
import com.ru.studybuddy.group.GroupService;
import com.ru.studybuddy.speciality.Specialty;
import com.ru.studybuddy.speciality.SpecialtyService;
import com.ru.studybuddy.user.rest.CreateStudentRequest;
import com.ru.studybuddy.user.rest.CreateStudentResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final DepartmentService departmentService;
    private final SpecialtyService specialtyService;
    private final GroupService groupService;
    private final PasswordEncoder encoder;

    public User getUser(String email) {
        return repository.getByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User with email " + email + "not found"));
    }

    public User setUser(RegisterRequest request) {
        Optional<User> optUser = repository.getByEmail(request.getEmail());
        if (optUser.isPresent()) {
            throw new EntityExistsException("User with email: " + request.getEmail() + " already exists");
        }
        var user = User.builder()
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .role(UserRole.ADMIN)
                .name(request.getName())
                .build();
        return repository.save(user);
    }

    private String getTemporarilyPassword(CreateStudentRequest request) {
        String password = request.getName().toLowerCase() + "_" + request.getDepartment().toLowerCase() + "_" + request.getSpecialty().toLowerCase() + "_" + request.getGroup();
        password = password.replace(" ", "");
        return password;

    }

    public CreateStudentResponse createStudent(CreateStudentRequest request) {

        Optional<User> optUser = repository.getByEmail(request.getEmail());
        if (optUser.isPresent()) {
            throw new EntityExistsException("User with email: " + request.getEmail() + " already exists");
        }

        Department department = departmentService.findByTitle(request.getDepartment());
        Specialty specialty = specialtyService.getByTitle(request.getSpecialty());
        Group group = groupService.findById(request.getGroup());
        String password = getTemporarilyPassword(request);

        User student = repository.save(User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(encoder.encode(password))
                .department(department)
                .specialty(specialty)
                .group(group)
                .role(UserRole.STUDENT)
                .build());
        return CreateStudentResponse.builder()
                .user(student)
                .status(204)
                .message("Student created")
                .build();
    }

    public List<User> get(String name, String department, String specialty, String groupId) {

        Specification<User> spec = Specification.where(UserSpecification.hasRole(UserRole.STUDENT));

        if(!name.isEmpty()) {
            spec = spec.and(UserSpecification.nameIncludes(name));
        }

        if (!department.isEmpty()) {
            spec = spec.and(UserSpecification.hasDepartment(department));
        }
        if (!specialty.isEmpty()) {
            spec = spec.and(UserSpecification.hasSpecialty(specialty));

        }
        if (!groupId.isEmpty()) {
            spec = spec.and(UserSpecification.hasGroup(groupId));
        }

        return repository.findAll(spec);
    }
}