package com.sbrf.reboot.repository;

import com.sbrf.reboot.service.Account;
import com.sbrf.reboot.service.AccountRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.SneakyThrows;

public class AccountRepositoryImpl implements AccountRepository {
    private String localPath;
    ObjectMapper mapper = new ObjectMapper();
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
        try {
            json = new String(Files.readAllBytes(Paths.get(localPath)));
        } catch (
                NoSuchFileException ex) {

            throw new FileNotFoundException(localPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            List<Account> listAccount = Arrays.asList(mapper.readValue(json, Account[].class));
//            for (Account nextAccount : listAccount) {
//                if (nextAccount.getClientId() == id) {
//                    accounts. add(nextAccount);
//                }
//            }
// переделал на stream
            accounts = listAccount.stream().filter(account -> account.getClientId() == id).collect(Collectors.toSet());
//            System.out.println("Выводим содержимое stream");
//            System.out.println(accounts);

            return accounts;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
