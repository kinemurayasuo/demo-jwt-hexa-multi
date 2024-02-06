package com.example.demo.auth.application.usecase.signin;

import com.example.demo.auth.application.usecase.data.TokenPair;

public interface SignInUseCase {
    TokenPair signIn(String username, String password);
}
