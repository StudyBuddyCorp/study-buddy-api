package com.ru.studybuddy.token.exception;

import jakarta.persistence.EntityNotFoundException;

public class TokenNotFoundException extends EntityNotFoundException {

    public TokenNotFoundException(String token) {
        super("Token \"" + token + "\" not found");
    }
}
