package lesson9.Shop;

/**
 * Created by l1s on 02.04.17.
 */
public class Transaction {
    private int id;
    private int userId;
    private int total;

    public Transaction(int userId, int total) {
        this.id = Math.abs(hashCode());
        this.userId = userId;
        this.total = total;
    }
}
