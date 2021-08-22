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

    public boolean isAccountExist(long clientId, Account account) throws FileNotFoundException {
        boolean flag = false;
        return accountRepository.getAllAccountsByClientId(clientId).contains(account);
        //        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
//        for (Account value : accounts) {
//            if (account.equals(value)) {
//                flag = true;
//                break;
//            }
//        }
//        return flag;
    }
}
