package com.sbrf.reboot.service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isAccountExist(long clientId, Account account) throws IOException {
        boolean flag = false;
        return accountRepository.getAllAccountsByClientId(clientId).contains(account);
    }

    public Account getMaxAccountBalance(long clientId) throws IOException {
        return accountRepository.getAllAccountsByClientId(clientId).stream().max(Comparator.comparing(Account::getBalance)).orElseThrow(NoSuchElementException::new);
    }

    public Set<Account> getAllAccountsByDateMoreThen(long clientId, Date createDate) throws IOException {
        return accountRepository.getAllAccountsByClientId(clientId).stream().filter(x -> x.getCreateDate().after(createDate)).collect(Collectors.toSet());
    }
}
