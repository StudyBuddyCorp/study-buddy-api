package com.ru.studybuddy.department;

import com.ru.studybuddy.group.Group;
import com.ru.studybuddy.speciality.Speciality;
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
public class Department {

    @Id
    private String title;

    @OneToMany
    private List<Speciality> specialties;

    @OneToMany
    private List<Group> groups;

    @OneToMany
    private List<User> users;
}
