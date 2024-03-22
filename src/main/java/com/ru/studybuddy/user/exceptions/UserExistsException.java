package com.ru.studybuddy.user.exceptions;

import jakarta.persistence.EntityExistsException;

public class UserExistsException extends EntityExistsException {
    public UserExistsException(String email) {
        super("User with email: " + email + " already exists");
    }
}
