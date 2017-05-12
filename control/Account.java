package control;

/**
 * Created by l1s on 10.05.17.
 */
public class Account {
    private static int id;
    private final int userId;
    private final String userName;
    private int balance;

    public Account(String userName, int balance) {
        this.userName = userName;
        this.balance = balance;
        userId = ++id;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return userId == account.userId;
    }

    @Override
    public int hashCode() {
        return userId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", balance=" + balance + "$" +
                '}';
    }
}