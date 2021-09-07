package com.sbrf.reboot.bankomate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ATMTest {
    @Mock
    ATM atm;
    Message message;
    Host host;

    @BeforeEach
    void setUp() {
        message = new Message(1, "Start");
        atm = new ATM(message);
        host = new Host();
    }

    @Test
    void LoadUnloadToFromXML() {
        atm.serializeMessageToXml();
        host.deserializeMessageFromXml();
        Assertions.assertEquals(atm.getMessage(), host.getMessage());
    }

    @Test
    void LoadUnloadToFromJSON() {
        atm.serializeMessageToJson();
        host.deserializeMessageFromJSON();
        Assertions.assertEquals(atm.getMessage(), host.getMessage());
    }

}
