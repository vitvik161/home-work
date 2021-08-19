package com.sbrf.reboot.service;

import lombok.Data;

@Data
public class Account {
    private long id;
    private String accNUM;

    public Account(String accNUM) {
        this.accNUM = accNUM;
        this.id = 1L;
    }
}
