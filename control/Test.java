package control;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        for (int i = 0; i < 100; i++) {
            bank.createAcc(new Account("user" + i, (int) (Math.random() * 500)));
        }

        

        Thread t1 = new Thread(new TransferThread(bank, acc1, acc2, 100));
        t1.start();

        t1.join();
    }
}
