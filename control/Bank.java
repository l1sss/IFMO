package control;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by l1s on 10.05.17.
 */
public class Bank {
    private Set<Account> accounts;

    public Bank() {
        accounts = new HashSet<>();
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void createAcc(Account acc) {
        accounts.add(acc);
    }

    public boolean checkAcc(Account acc, Account acc2) {
        return accounts.contains(acc) && accounts.contains(acc2);
    }

    public boolean transferMoney(Account acc1, Account acc2, int amout) {
        if (acc1.getBalance() < amout) {
            System.err.println("insufficient funds");

            return false;
        }

        acc1.setBalance(acc1.getBalance() - amout);
        acc2.setBalance(acc2.getBalance() + amout);

        return true;
    }
}