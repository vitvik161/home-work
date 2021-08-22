package com.sbrf.reboot.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Account {
    private long clientId;
    private String number;

    public Account(String number) {
        this.number = number;
        clientId = 1L;
    }
    @JsonCreator
    public Account(@JsonProperty("clientId") long clientId, @JsonProperty("number") String number) {
        this.clientId = clientId;
        this.number = number;
    }
}
