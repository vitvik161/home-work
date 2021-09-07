package com.sbrf.reboot.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Account {
    private long clientId;
    private String number;
    private Date createDate;
    private double balance;

    public Account(String number) {
        this.number = number;
        clientId = 1L;
    }

    public Account(long clientId, String number, Date createDate, double balance) {
        this.clientId = clientId;
        this.number = number;
        this.balance = balance;
        this.createDate = createDate;
    }

    @JsonCreator
    public Account(@JsonProperty("clientId") long clientId, @JsonProperty("number") String number) {
        this.clientId = clientId;
        this.number = number;
    }
}
