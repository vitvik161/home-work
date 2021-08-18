package com.sbrf.reboot.service;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isAccountExist(long l, Account account) {
        boolean flag;
        flag = account.getId() == l;
        return flag;
    }
}
