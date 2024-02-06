package com.example.demo.auth.rdb.repository;

import com.example.demo.auth.rdb.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountJpaRepository extends JpaRepository <AccountEntity, UUID> {
}
