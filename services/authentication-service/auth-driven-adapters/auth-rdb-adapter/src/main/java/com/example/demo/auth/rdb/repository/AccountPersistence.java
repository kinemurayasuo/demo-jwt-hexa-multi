package com.example.demo.auth.rdb.repository;

import com.example.auth.domain.Account;
import com.example.demo.auth.application.repository.AccountRepository;
import com.example.demo.auth.rdb.entity.AccountEntity;
import com.example.demo.auth.rdb.mapper.AccountEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountPersistence implements AccountRepository {

    private final AccountEntityMapper mapper;
    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Account save(Account account) {
        AccountEntity entity = mapper.from(account);

        AccountEntity saveEntity = accountJpaRepository.save(entity);

        Account savedDomain = mapper.from(saveEntity);

        return savedDomain;
    }
}
