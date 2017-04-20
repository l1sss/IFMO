package collections.shop;

import java.util.Date;

/**
 * Created by l1s on 02.04.17.
 */
public class Transaction {
    private Date currentDate;
    private static int trId = 1;
    private int id;
    private int userId;
    private int total;

    public Transaction(int userId, int total) {
        this.id = trId++;
        this.userId = userId;
        this.total = total;
        this.currentDate = new Date();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "currentDate=" + currentDate +
                ", id=" + id +
                ", userId=" + userId +
                ", total=" + total +
                '}';
    }
}
