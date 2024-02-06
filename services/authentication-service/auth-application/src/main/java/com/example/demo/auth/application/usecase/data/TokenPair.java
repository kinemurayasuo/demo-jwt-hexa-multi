package com.example.demo.auth.application.usecase.data;

import lombok.Builder;

@Builder
public record TokenPair(
        String accessToken,
        String refreshToken
) {
}
