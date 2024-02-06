package com.example.demo.auth.application.service;

import com.example.auth.domain.Account;
import com.example.demo.auth.application.repository.AccountRepository;
import com.example.demo.auth.application.usecase.data.TokenPair;
import com.example.demo.auth.application.usecase.signin.SignInUseCase;
import com.example.demo.auth.application.usecase.signup.SignUpUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements SignInUseCase, SignUpUseCase {

    private final AccountRepository accountRepository;
    // PasswordEncoder 추가
    private final PasswordEncoder passwordEncoder;


    @Override
    public Account signUp(Account account) {
        String password = passwordEncoder.encode(account.password);
        Account clonedAccount = account.toBuilder()
                .password(password)
                .build();
        Account savedAccount = accountRepository.save(clonedAccount);

        return savedAccount;
    }
    @Override
    public TokenPair signIn(String username, String password) {
        return TokenPair.builder()
                .accessToken("이건 엑세스 토큰")
                .refreshToken("이건 리플레시 토큰")
                .build();
    }

}
