package multithreading.bank;

import collections.arrayList.ArrayList;
import collections.linkedList.List;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            accounts.add(new Account("user" + i, 1000));
        }

        int sum = 0;
        for (Account a : accounts) {
            sum += a.getBalance();
        }

        System.out.println("Sum before operations: " + sum + "\n");
        Thread.sleep(1000);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        Account a1 = null;
        Account a2 = null;

        for (int i = 0; i < 10000; i++) {
            int r = (int)(Math.random() * accounts.size());
            int r2 = (int) (Math.random() * accounts.size());
            int amount = (int) (Math.random() * 1000);

            a1 = accounts.get(r);
            a2 = accounts.get(r2);

            pool.submit(new transferMoney(bank, a1, a2, amount));
        }

        pool.shutdown();

        Thread.sleep(5000);

        int resultSum = 0;
        for (Account a : accounts) {
            resultSum += a.getBalance();
        }

        for (Account a : accounts) {
            System.out.println(a);
        }

        System.out.println("\n" + (char)27 + "[0mSum after operations: " + resultSum);

        bank.mailerOff();

        /*//тестирование корректности работы на малом кол-ве пользователей
        Account acc2 = new Account("Loo", 2000);
        Account acc1 = new Account("Jo", 2000);

        for (int i = 0; i < 10; i++) {
            bank.transferMoney(acc1, acc2, 100);
            bank.transferMoney(acc2, acc1, 100);
        }

        Thread.sleep(1000);
        bank.mailerOff();*/
    }
}

class transferMoney implements Runnable {
    private Bank bank;
    private Account acc1;
    private Account acc2;
    private int amount;

    public transferMoney(Bank bank, Account acc1, Account acc2, int amount) {
        this.bank = bank;
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.amount = amount;
    }

    @Override
    public void run() {
        bank.transferMoney(acc1, acc2, amount);
    }
}