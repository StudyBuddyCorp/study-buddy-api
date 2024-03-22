package com.ru.studybuddy.user.exceptions;

import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException(String email) {
        super("User with email " + email + "not found");
    }

    public UserNotFoundException(UUID id) {
        super("User with id " + id + "not found");

    }
}
