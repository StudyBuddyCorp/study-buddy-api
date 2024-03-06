package com.ru.template.repositories;

import com.ru.template.entities.token.Token;
import com.ru.template.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {
    Optional<Token> getByRefreshToken(String refreshToken);

    Optional<Token> getByUser(User user);
}
