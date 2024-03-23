package com.ru.studybuddy.user.exceptions;
import jakarta.persistence.NoResultException;

public class UserIllegalAccess extends NoResultException{
    public UserIllegalAccess (){super("An illegal attempt to create a user without a name");}
}
