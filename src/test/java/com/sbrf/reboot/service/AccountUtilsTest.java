package com.sbrf.reboot.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountUtilsTest {

    @Mock
    AccountUtils accountUtils;
    ArrayList<Account> accountArrayList;
    ArrayList<Account> accountArrayListReference;

    @BeforeEach
    void setUp() {
        accountUtils = new AccountUtils();
        accountArrayList = new ArrayList<>();
        accountArrayListReference = new ArrayList<>();

    }

    @Test
    void correctSortById() throws ParseException {

        accountArrayList.add(new Account(3L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2003-1-1 10:00:00"), 3.33));
        accountArrayList.add(new Account(2L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2002-1-1 10:00:00"), 2.22));
        accountArrayList.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2014-1-1 10:00:00"), 1.11));


        accountArrayListReference.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2014-1-1 10:00:00"), 1.11));
        accountArrayListReference.add(new Account(2L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2002-1-1 10:00:00"), 2.22));
        accountArrayListReference.add(new Account(3L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2003-1-1 10:00:00"), 3.33));

        Assertions.assertEquals(accountArrayListReference, accountUtils.sortedById(accountArrayList));
    }

    @Test
    void correctSortByIdDate() throws ParseException {

        accountArrayList.add(new Account(1L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2003-1-1 10:00:00"), 3.33));
        accountArrayList.add(new Account(1L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2002-1-1 10:00:00"), 2.22));
        accountArrayList.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2014-1-1 10:00:00"), 1.11));


        accountArrayListReference.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2014-1-1 10:00:00"), 1.11));
        accountArrayListReference.add(new Account(1L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2003-1-1 10:00:00"), 3.33));
        accountArrayListReference.add(new Account(1L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2002-1-1 10:00:00"), 2.22));

        Assertions.assertEquals(accountArrayListReference, accountUtils.sortedByIdDate(accountArrayList));
    }

    @Test
    void correctSortByIdDateBalance() throws ParseException {

        accountArrayList.add(new Account(1L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2001-1-1 10:00:00"), 3.33));
        accountArrayList.add(new Account(1L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2001-1-1 10:00:00"), 2.22));
        accountArrayList.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2001-1-1 10:00:00"), 1.11));


        accountArrayListReference.add(new Account(1L, "ACC01", new SimpleDateFormat("y-M-d H:m:s").parse("2001-1-1 10:00:00"), 1.11));
        accountArrayListReference.add(new Account(1L, "ACC02", new SimpleDateFormat("y-M-d H:m:s").parse("2001-1-1 10:00:00"), 2.22));
        accountArrayListReference.add(new Account(1L, "ACC03", new SimpleDateFormat("y-M-d H:m:s").parse("2001-1-1 10:00:00"), 3.33));

        Assertions.assertEquals(accountArrayListReference, accountUtils.sortedByIdDateBalance(accountArrayList));
    }

}
