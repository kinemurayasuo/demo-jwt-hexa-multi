package com.example.demo.auth.application.repository;

import com.example.auth.domain.Account;

public interface AccountRepository {
    Account save(Account account);
}
