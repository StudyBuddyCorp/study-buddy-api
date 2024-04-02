package com.ru.studybuddy.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {
    Optional<User> getByEmail(String email);

    @Query("select count(u) from User u where u.role = ?1")
    long countByRole(UserRole role);

    List<User> findAllByGroupId(UUID groupId);
}
