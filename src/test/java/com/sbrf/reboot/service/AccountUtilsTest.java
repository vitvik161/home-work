package com.sbrf.reboot.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class AccountUtilsTest {

    @Mock
    AccountUtils accountUtils;

    @BeforeEach
    void setUp() {
        accountUtils = new AccountUtils();
    }

    @Test
    void correctSortById() throws ParseException {
        ArrayList<Account> accountArrayList = new ArrayList<>();

        accountArrayList.add(new Account(3L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2003-1-1 10:00:00"), 3.33));
        accountArrayList.add(new Account(2L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2002-1-1 10:00:00"), 2.22));
        accountArrayList.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2014-1-1 10:00:00"), 1.11));

        ArrayList<Account> accountArrayList1 = new ArrayList<>();

        accountArrayList1.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2014-1-1 10:00:00"), 1.11));
        accountArrayList1.add(new Account(2L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2002-1-1 10:00:00"), 2.22));
        accountArrayList1.add(new Account(3L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2003-1-1 10:00:00"), 3.33));

        Assertions.assertEquals(accountArrayList1, accountUtils.sortedById(accountArrayList));
    }

    @Test
    void correctSortByIdDate() throws ParseException {
        ArrayList<Account> accountArrayList = new ArrayList<>();

        accountArrayList.add(new Account(1L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2003-1-1 10:00:00"), 3.33));
        accountArrayList.add(new Account(1L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2002-1-1 10:00:00"), 2.22));
        accountArrayList.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2014-1-1 10:00:00"), 1.11));

        ArrayList<Account> accountArrayList1 = new ArrayList<>();

        accountArrayList1.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2014-1-1 10:00:00"), 1.11));
        accountArrayList1.add(new Account(1L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2003-1-1 10:00:00"), 3.33));
        accountArrayList1.add(new Account(1L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2002-1-1 10:00:00"), 2.22));

        Assertions.assertEquals(accountArrayList1, accountUtils.sortedByIdDate(accountArrayList));
    }

    @Test
    void correctSortByIdDateBalance() throws ParseException {
        ArrayList<Account> accountArrayList = new ArrayList<>();

        accountArrayList.add(new Account(1L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2001-1-1 10:00:00"), 3.33));
        accountArrayList.add(new Account(1L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2001-1-1 10:00:00"), 2.22));
        accountArrayList.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2001-1-1 10:00:00"), 1.11));

        ArrayList<Account> accountArrayList1 = new ArrayList<>();

        accountArrayList1.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2001-1-1 10:00:00"), 1.11));
        accountArrayList1.add(new Account(1L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2001-1-1 10:00:00"), 2.22));
        accountArrayList1.add(new Account(1L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2001-1-1 10:00:00"), 3.33));

        Assertions.assertEquals(accountArrayList1, accountUtils.sortedByIdDateBalance(accountArrayList));
    }

}
