package com.ru.studybuddy.user.exceptions;
import jakarta.persistence.NoResultException;

public class UserNoResult extends NoResultException{
    public UserNoResult (String string){super("An illegal attempt to create a user without necessary string: "+ string);}
}
