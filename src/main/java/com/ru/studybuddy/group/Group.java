package com.ru.studybuddy.group;

import com.ru.studybuddy.department.Department;
import com.ru.studybuddy.speciality.Speciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String group;

    @ManyToOne
    private Speciality specialty;

    @ManyToOne
    private Department department;
}
