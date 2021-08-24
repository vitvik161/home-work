package com.sbrf.reboot.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isAccountExist(long clientId, Account account) throws IOException {
        boolean flag = false;
        return accountRepository.getAllAccountsByClientId(clientId).contains(account);
    }
}
