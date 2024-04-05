package com.ru.studybuddy.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class UserDto extends RepresentationModel<UserDto> implements Serializable {
    private UUID id;
    private String name;
    private String email;
    private String departmentTitle;
    private String specialtyTitle;
    private UUID groupId;
    private int groupNumber;
}
