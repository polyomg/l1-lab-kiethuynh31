package com.lab8.service;

import com.lab8.entity.Account;
import java.util.List;

public interface AccountService {
    Account findById(String username);
    List<Account> findAll();
    Account save(Account acc);
}
