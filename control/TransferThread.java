package control;

/**
 * Created by l1s on 10.05.17.
 */
class TransferThread implements Runnable {
    private Bank bank;
    private Account acc1;
    private Account acc2;
    private int amout;

    TransferThread(Bank bank, Account acc1, Account acc2, int amout) {
        this.bank = bank;
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.amout = amout;
    }

    @Override
    public void run() {
        synchronized (acc1) {
            synchronized (acc2) {
                if (! bank.checkAcc(acc1, acc2)) {
                    System.err.println("Invalid User!");

                    return;
                }

                bank.transferMoney(acc1, acc2, amout);
            }
        }
    }
}
