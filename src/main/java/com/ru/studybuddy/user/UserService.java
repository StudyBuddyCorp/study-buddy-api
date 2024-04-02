package com.ru.studybuddy.user;


import com.ru.studybuddy.auth.RegisterRequest;
import com.ru.studybuddy.department.Department;
import com.ru.studybuddy.department.DepartmentService;
import com.ru.studybuddy.group.Group;
import com.ru.studybuddy.group.GroupService;
import com.ru.studybuddy.speciality.Specialty;
import com.ru.studybuddy.speciality.SpecialtyService;
import com.ru.studybuddy.user.exceptions.UserExistsException;
import com.ru.studybuddy.user.exceptions.UserNoResult;
import com.ru.studybuddy.user.exceptions.UserNotFoundException;
import com.ru.studybuddy.user.rest.CreateStudentRequest;
import com.ru.studybuddy.user.rest.CreateStudentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.mediatype.hal.HalModelBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository repository;
    private final DepartmentService departmentService;
    private final SpecialtyService specialtyService;
    private final GroupService groupService;
    private final PasswordEncoder encoder;
    private final UserModelAssembler assembler;

    public User getUser(String email) {
        return repository.getByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));
    }

    public User setUser(RegisterRequest request) {
        String email = request.getEmail();
        if (request.getName() == null) {
            throw new UserNoResult("name");
        }
        if (request.getEmail() == null) {
            throw new UserNoResult("email");
        }
        Optional<User> optUser = repository.getByEmail(email);
        if (optUser.isPresent()) {
            throw new UserExistsException(email);
        }
        return repository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(encoder.encode(request.getPassword()))
                        .role(UserRole.ADMIN)
                        .name(request.getName())
                        .build());
    }

    private String getTemporarilyPassword(CreateStudentRequest request) {
        String password = request.getName().toLowerCase() + "_" + request.getDepartment().toLowerCase() + "_" + request.getSpecialty().toLowerCase() + "_" + request.getGroup();
        password = password.replace(" ", "");
        return password;

    }

    public CreateStudentResponse createStudent(CreateStudentRequest request) {
        String email = request.getEmail();
        Optional<User> optUser = repository.getByEmail(email);
        if (optUser.isPresent()) {
            throw new UserExistsException(email);
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

    public EntityModel<UserDto> one(UUID id) {
        return assembler.toModel(get(id));
    }

    public RepresentationModel<UserDto> allStudents(String name, String departmentTitle, String specialtyTitle, UUID groupId) {
        log.info("Name " + name);
        log.info("Department title " + departmentTitle);
        log.info("Speciality title " + specialtyTitle);
        log.info("Group id" + groupId);
        Specification<User> userSpec = new UserSpecification(
                UserRole.STUDENT,
                name,
                departmentTitle,
                specialtyTitle,
                groupId
        );
        log.info(userSpec.toString());

        List<EntityModel<UserDto>> students = repository.findAll(userSpec).stream()
                .map(assembler::toModel).toList();
        return HalModelBuilder.emptyHalModel()
                .embed(!students.isEmpty() ? students : Collections.emptyList(), UserDto.class)
                .link(linkTo(methodOn(UserController.class).getStudents(name, departmentTitle, specialtyTitle, groupId)).withSelfRel())
                .build();
    }

    public Long count(UserRole role) {

        if (role == null) {
            return repository.count();
        }
        return repository.countByRole(role);
    }

    public User get(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> getAllByGroupId(UUID groupId) {
        return repository.findAllByGroupId(groupId);
    }
}