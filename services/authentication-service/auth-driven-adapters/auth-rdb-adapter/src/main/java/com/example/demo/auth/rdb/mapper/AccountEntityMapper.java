package com.example.demo.auth.rdb.mapper;

import com.example.auth.domain.Account;
import com.example.demo.auth.rdb.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface AccountEntityMapper {
    Account from(AccountEntity entity);
    AccountEntity from(Account domain);
}
