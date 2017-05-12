package control;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        for (int i = 0; i < 100; i++) {
            bank.createAcc(new Account("user" + i, 300));
        }

        int sum = 0;
        for (Account a : bank.getAccounts()) {
            sum += a.getBalance();
        }

        System.out.println("Sum before operations: " + sum + "\n");
        Thread.sleep(1000);

        for (int i = 0; i < 50; i++) {
            int r = (int) (Math.random() * 100);
            int r2 = (int) (Math.random() * 100);
            int amout = (int) (Math.random() * 500);

            Account a1 = bank.getAccounts().get(r);
            Account a2 = bank.getAccounts().get(r2);

            bank.transferMoney(a1, a2, amout);
        }

        int resultSum = 0;
        for (Account a : bank.getAccounts()) {
            resultSum += a.getBalance();
        }

        bank.mailerOff();

        Thread.sleep(1000);
        System.out.println("\n" + (char)27 + "[0mSum after operations: " + resultSum);

        //тестирование корректности работы на малом кол-ве пользователей
        /*Account acc1 = new Account("Jo", 2000);
        Account acc2 = new Account("Loo", 2000);

        bank.createAcc(acc1);
        bank.createAcc(acc2);

        bank.transferMoney(acc1, acc2, 1000);
        bank.transferMoney(acc2, acc1, 3001);*/
    }
}