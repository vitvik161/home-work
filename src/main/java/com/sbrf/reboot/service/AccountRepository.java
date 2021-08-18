package com.sbrf.reboot.service;

import com.sbrf.reboot.service.Account;

import java.util.HashSet;
import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(long id);
}
