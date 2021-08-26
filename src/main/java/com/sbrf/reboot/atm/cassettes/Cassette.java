package com.sbrf.reboot.atm.cassettes;

import java.util.ArrayList;

public class Cassette<T extends Banknote> {

    ArrayList<T> list;

    public Cassette(ArrayList<T> listBanknote) {
        list = listBanknote;
    }

    public int getCountBanknotes() {
        return list.size();
    }
}
