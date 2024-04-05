package com.ru.studybuddy.user;

import java.io.Serializable;
import java.util.UUID;

public interface UserProjection extends Serializable {
    UUID getId();
    String getName();
    String getEmail();
    String getDepartmentTitle();
    String getSpecialtyTitle();
    String getGroup();
}
