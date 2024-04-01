package com.ru.studybuddy.token.exception;


public class TokensNotEqualException extends RuntimeException {
    public TokensNotEqualException() {
        super("Tokens are not equal");
    }
}
