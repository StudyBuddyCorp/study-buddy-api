package com.ru.studybuddy.user;

import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class UserSpecification {

    private UserSpecification(){}

    public static Specification<User> hasRole(UserRole role) {
        return (user, cq, cb) -> cb.equal(user.get("role"), role);
    }

    public static Specification<User> nameIncludes(String name) {
        return (user, cq, cb) -> cb.like(cb.lower(user.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<User> hasDepartment(String department) {
        return (user, cq, cb) -> cb.equal(user.get("department").get("title"), department);
    }

    public static Specification<User> hasSpecialty(String specialty) {
        return (user, cq, cb) -> cb.equal(user.get("speciality").get("title"), specialty);
    }

    public static Specification<User> hasGroup(String group) {
        return (user, cq, cb) -> cb.equal(user.get("group").get("id"), UUID.fromString(group));
    }
}
