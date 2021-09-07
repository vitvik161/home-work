package com.sbrf.reboot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class AccountUtils {
    public ArrayList<Account> sortedById(ArrayList<Account> accountList) {
        Comparator<Account> comparator = new Comparator<Account>() {
            @Override
            public int compare(Account left, Account right) {
//                return left.getClientId() == right.getClientId() ? 0 : (left.getClientId() > right.getClientId() ? 1 : -1);
                return Long.compare(left.getClientId(), right.getClientId());
            }
        };
        Collections.sort(accountList, comparator);
        return accountList;
    }

    public ArrayList<Account> sortedByIdDate(ArrayList<Account> accountList) {
        Comparator<Account> comparator = new Comparator<Account>() {
            @Override
            public int compare(Account left, Account right) {
//                int compareId = left.getClientId() > right.getClientId() ? 1 : (left.getClientId() == right.getClientId() ? 0 : -1);
                int compareId = Long.compare(left.getClientId(), right.getClientId());
                return (compareId != 0) ? compareId : -1 * left.getCreateDate().compareTo(right.getCreateDate());
            }
        };
        Collections.sort(accountList, comparator);
        return accountList;
    }

    public ArrayList<Account> sortedByIdDateBalance(ArrayList<Account> accountList) {
        Comparator<Account> comparator = new Comparator<Account>() {
            @Override
            public int compare(Account left, Account right) {
//                int compareId = left.getClientId() > right.getClientId() ? 1 : (left.getClientId() == right.getClientId() ? 0 : -1);
                int compareId = Long.compare(left.getClientId(), right.getClientId());
                int compareCreateDate = left.getCreateDate().compareTo(right.getCreateDate());
//                int compareBalance = left.getBalance() > right.getBalance() ? 1 : (left.getBalance() == right.getBalance() ? 0 : -1);
                int compareBalance = Double.compare(left.getBalance(), right.getBalance());
//                return compareId != 0 ? compareId : (compareCreateDate != 0 ? compareCreateDate : (compareBalance != 0 ? compareBalance : 0));
                return compareId != 0 ? compareId : (compareCreateDate != 0 ? compareCreateDate : compareBalance);
            }
        };
        Collections.sort(accountList, comparator);
        return accountList;
    }

}
