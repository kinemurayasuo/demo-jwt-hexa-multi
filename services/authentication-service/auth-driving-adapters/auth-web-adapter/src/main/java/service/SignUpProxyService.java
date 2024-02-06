package service;

import com.example.auth.domain.Account;
import com.example.auth.domain.types.AccountStatus;
import com.example.demo.auth.application.usecase.signup.SignUpUseCase;
import dto.SignInDto.SignInRequestDto;
import dto.SignUpDto.SignUpRequestDto;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import mapper.AccountDtoMapper;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class SignUpProxyService {
    private final SignUpUseCase signUpUseCase;
    private final AccountDtoMapper mapper;

    public Account SignUp(SignUpRequestDto dto, AccountStatus status) {
        Account account = mapper.from(dto, status);
        Account savedAccount = signUpUseCase.signUp(account);

        return savedAccount;
    }

}
