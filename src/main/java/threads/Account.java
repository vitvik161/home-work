package threads;

import java.util.Date;

public class Account {
    private int sum;
    private String currency;
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public String getCurrency() {
        return currency;
    }

    public int getSum() {
        return sum;
    }

    public Account(int sum, String currency, Date createDate) {
        this.sum = sum;
        this.currency = currency;
        this.createDate = createDate;
    }
}
