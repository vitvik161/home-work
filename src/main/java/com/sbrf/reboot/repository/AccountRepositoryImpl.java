package com.sbrf.reboot.repository;

import com.sbrf.reboot.service.Account;
import com.sbrf.reboot.service.AccountRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashSet;
import java.util.Set;

public class AccountRepositoryImpl implements AccountRepository {
    private String localPath;
    private long id;

    public AccountRepositoryImpl(String localPath) {
        this.localPath = localPath;
        System.out.println(localPath);

    }

    //    @SneakyThrows
    @Override
    public Set<Account> getAllAccountsByClientId(long id) throws FileNotFoundException {
        Set<Account> accounts = new HashSet();
        String json = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(localPath))) {
            String line;
            int localCnt = 0;
            Long localClientId = null;
            String localNumber = null;
            while ((line = reader.readLine()) != null) {
                if (line.indexOf("\"clientId\": ") > 0) {
                    localClientId = Long.parseLong(line.substring(line.indexOf("\": ") + 3, line.length() - 1));
                }
                if (line.indexOf("\"number\": ") > 0) {
                    localNumber = line.substring(line.indexOf("\": \"") + 4, line.length() - 1);
                    localCnt = 1;
                }
                if (localCnt == 1) {
                    System.out.println(localClientId + "  -  " + localNumber);
                    if (localClientId == id) {
                        accounts.add(new Account(localClientId, localNumber));
                    }
                    localCnt = 0;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(localPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(accounts);
        return accounts;
    }
}
