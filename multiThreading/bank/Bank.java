package multiThreading.bank;

/**
 * Created by l1s on 10.05.17.
 */
public class Bank {
    private MailerThread mailer;
    private Thread tMailer;

    public Bank() {
        mailer = new MailerThread();
        tMailer = new Thread(mailer);
        tMailer.start();
    }

    public void mailerOff() {
        tMailer.interrupt();
    }

    public void transferMoney(Account acc1, Account acc2, int amount) {
        synchronized (getLowId(acc1, acc2)) {
            if (acc1.getBalance() < amount) {
                mailer.addToQ(0);

                return;
            }
            synchronized (getHighId(acc1, acc2)) {
                acc1.setBalance(acc1.getBalance() - amount);
                acc2.setBalance(acc2.getBalance() + amount);

                mailer.addToQ(1);
            }
        }
    }


    private Account getLowId(Account acc1, Account acc2) {
        if (acc1.equals(acc2))
            return acc1;

        if (acc1.getUserId() < acc2.getUserId()) return acc1;
        else return acc2;
    }

    private Account getHighId(Account acc1, Account acc2) {
        if (acc1.equals(acc2))
            return acc2;

        if (acc1.getUserId() > acc2.getUserId()) return acc1;
        else return acc2;
    }
}