package com.sbrf.reboot.bankomate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Message {
    private int messageId;
    private String value;

    @JsonCreator
    public Message(@JsonProperty("messageId") int messageId, @JsonProperty("value") String value) {
        this.messageId = messageId;
        this.value = value;
    }
}
