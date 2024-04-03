package com.ru.studybuddy.user;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Builder
public class UserSpecification implements Specification<User> {

    private final UserRole role;
    private final String name;
    private final String departmentTitle;
    private final String specialtyTitle;
    private final UUID groupId;

    @Override
    public Predicate toPredicate(
            @NonNull Root<User> user,
            @NonNull CriteriaQuery<?> query,
            @NonNull CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (role != null) {
            predicates.add(cb.equal(user.get("role"), role));
        }

        if (name != null) {
            predicates.add(cb.like(cb.lower(user.get("name")), "%" + name.toLowerCase() + "%"));
        }

        if (role == UserRole.STUDENT && departmentTitle != null) {
            predicates.add(cb.equal(user.join("department").get("title"), departmentTitle));
        }

        if (role == UserRole.STUDENT && specialtyTitle != null) {
            predicates.add(cb.equal(user.join("specialty").get("title"), specialtyTitle));
        }

        if (role == UserRole.STUDENT && groupId != null) {
            predicates.add(cb.equal(user.join("group").get("id"), groupId));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
