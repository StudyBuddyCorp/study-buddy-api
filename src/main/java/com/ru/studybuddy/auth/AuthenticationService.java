package com.ru.studybuddy.auth;


import com.ru.studybuddy.errors.CookieException;
import com.ru.studybuddy.token.Token;
import com.ru.studybuddy.token.TokenService;
import com.ru.studybuddy.user.UserService;
import com.ru.studybuddy.user.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserService userService;

    public AuthenticationResponse registration(RegisterRequest request, HttpServletResponse httpServletResponse) {
        User user = userService.setUser(request);
        login(request);

        return buildResponse(user, httpServletResponse);
    }

    public AuthenticationResponse login(AuthenticationRequest request, HttpServletResponse httpServletResponse) {
        User user = userService.getUser(request.getEmail());
        login(request);

        return buildResponse(user, httpServletResponse);
    }

    public AuthenticationResponse refresh(String requestToken, HttpServletResponse httpServletResponse) {
        Token token = tokenService.getToken(requestToken);
        tokenService.checkEquals(requestToken, token);
        String email = tokenService.getUsername(requestToken);
        User user = userService.getUser(email);

        return buildResponse(user, httpServletResponse);
    }

    public void logout(String refreshToken) {
        tokenService.deleteToken(refreshToken);
    }


    private void setTokenToCookie(HttpServletResponse response, String token) {
        try {
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        } catch (Exception e) {
            throw new CookieException("Setting cookie exception");
        }
    }

    private AuthenticationResponse buildResponse(User user, HttpServletResponse httpServletResponse) {
        String refreshToken = tokenService.generateAccessToken(user);
        String accessToken = tokenService.generateRefreshToken(user);
        tokenService.setTokenToRepository(refreshToken, user);
        setTokenToCookie(httpServletResponse, refreshToken);
        return AuthenticationResponse.builder()
                .token(accessToken)
                .user(user)
                .build();
    }

    private void login(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (RuntimeException e) {
            throw new AuthenticationServiceException("Password is wrong");
        }
    }

    private void login(RegisterRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
    }
}