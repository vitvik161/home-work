package com.sbrf.reboot.service;

import com.sbrf.reboot.service.Account;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(long id) throws IOException;
}
