package com.lab8.service;

import com.lab8.entity.Account;
import com.lab8.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository repo;

    @Override
    public Account findById(String username) {
        return repo.findById(username).orElse(null);
    }

    @Override
    public List<Account> findAll() {
        return repo.findAll();
    }

    @Override
    public Account save(Account acc) {
        return repo.save(acc);
    }
}
