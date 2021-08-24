package com.sbrf.reboot.repository;

import com.sbrf.reboot.service.Account;
import com.sbrf.reboot.service.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountRepositoryImplTest {

    AccountRepository accountRepository;


    @Test
    void onlyPersonalAccounts()  throws IOException{
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1);
        System.out.println("Это возвращает функция");
        System.out.println(allAccountsByClientId);
        ArrayList<Account> accounts = new ArrayList<Account>() {{
            add(new Account(1,"2-ACCNUM"));
            add(new Account(1,"1-ACCNUM"));
            add(new Account(1,"4-ACC1NUM"));
        }};
        System.out.println("Это массив");
        System.out.println(accounts);

        assertTrue(accounts.containsAll(allAccountsByClientId));
    }

    @Test
    void successGetAllAccountsByClientId()  throws IOException{
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(2);
        Assertions.assertTrue(allAccountsByClientId.contains(new Account(2,"5-ACC1NUM")));
    }

    @Test
    void failGetAllAccountsByClientId(){
        accountRepository = new AccountRepositoryImpl("somePath");
        assertThrows(FileNotFoundException.class, () -> {
            accountRepository.getAllAccountsByClientId(1L);
        });
    }


}