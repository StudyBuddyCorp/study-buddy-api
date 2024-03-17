package com.ru.studybuddy.user;

import java.util.UUID;

public interface UserNameEmailDepartmentSpecialtyGroup {

    UUID getId();
    UserRole getRole();
    String getEmail();
    String getName();
    DepartmentView getDepartment();
    SpecialityView getSpeciality();
    GroupView getGroup();

    interface DepartmentView {
        String getTitle();
    }

    interface SpecialityView {
        String getTitle();
    }
    interface GroupView {
        UUID getId();
        String getGroup();
    }

}
