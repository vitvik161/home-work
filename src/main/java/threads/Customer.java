package threads;

import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private short age;
    private String name;
    private ArrayList<Account> arrayList;

    public short getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Account> getArrayList() {
        return arrayList;
    }

    public Customer(short age, String name, ArrayList<Account> arrayList) {
        this.age = age;
        this.name = name;
        this.arrayList = arrayList;
    }
}
