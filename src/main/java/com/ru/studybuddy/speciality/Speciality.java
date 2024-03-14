package com.ru.studybuddy.speciality;

import com.ru.studybuddy.department.Department;
import com.ru.studybuddy.group.Group;
import com.ru.studybuddy.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Speciality {

    @Id
    private String title;

    @OneToMany
    private List<Group> groups;

    @ManyToOne
    private Department department;

    @OneToMany
    private List<User> users;
}
