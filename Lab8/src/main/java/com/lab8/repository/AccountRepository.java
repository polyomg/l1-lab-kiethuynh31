package com.lab8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab8.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
}
