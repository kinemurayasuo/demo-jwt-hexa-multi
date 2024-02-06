package service;

import com.example.demo.auth.application.usecase.data.TokenPair;
import com.example.demo.auth.application.usecase.signin.SignInUseCase;
import dto.SignInDto.SignInRequestDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInProxyService {
    private final SignInUseCase signInUseCase;

    public String SignIn(SignInRequestDto dto, HttpServletResponse response) {
        TokenPair tokenPair = signInUseCase.signIn(dto.username(), dto.password());

        Cookie cookie = new Cookie("refresh_token", tokenPair.refreshToken());
        cookie.setMaxAge(2_592_000);
        cookie.setDomain("");
        cookie.setPath("/");
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
        return tokenPair.accessToken();
    }
}
