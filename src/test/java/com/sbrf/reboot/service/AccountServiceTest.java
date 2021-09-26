package com.sbrf.reboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    AccountService accountService;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);

        accountService = new AccountService(accountRepository);
    }

    @Test
    void bookExist() throws IOException {
        Account account = new Account("ACC1234NUM");
        Set<Account> accounts = new HashSet();
        accounts.add(account);

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertTrue(accountService.isAccountExist(1L, account));
    }

    @Test
    void bookNotExist() throws IOException {
        Set<Account> accounts = new HashSet();
        accounts.add(new Account("ACC1234NUM"));

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertFalse(accountService.isAccountExist(1L, new Account("ACC456NUM")));
    }

    @Test
    void getMaxAccountBalance() throws IOException, ParseException {
        Account account = new Account(1L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2003-1-1 10:00:00"), 3.33);
        Set<Account> accounts = new HashSet();

        accounts.add(account);
        accounts.add(new Account(1L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2002-1-1 10:00:00"), 2.22));
        accounts.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2014-1-1 10:00:00"), 1.11));

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        Assertions.assertEquals(account, accountService.getMaxAccountBalance(1L));
    }

    @Test
    void getAllAccountsByDateMoreThen () throws IOException, ParseException {
        Set<Account> accounts = new HashSet();
        accounts.add(new Account(1L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2003-1-1 10:00:00"), 3.33));
        accounts.add(new Account(1L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2002-1-1 10:00:00"), 2.22));
        accounts.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2014-1-1 10:00:00"), 1.11));

        Set<Account> accountsReference = new HashSet();
        accountsReference.add(new Account(1L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2003-1-1 10:00:00"), 3.33));
        accountsReference.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2014-1-1 10:00:00"), 1.11));

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        Assertions.assertEquals(accountsReference, accountService.getAllAccountsByDateMoreThen(1L, new SimpleDateFormat("y-M-d H:m:s").parse("2002-1-1 10:00:00")));
    }


}