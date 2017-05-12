package control;

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

    public void transferMoney(Account acc1, Account acc2, int amout) {
        Thread tTrans = new Thread(new TransferThread(acc1, acc2, amout));
        tTrans.start();
    }

    private class TransferThread implements Runnable {
        private Account acc1;
        private Account acc2;
        private int amout;

        TransferThread(Account acc1, Account acc2, int amout) {
            this.acc1 = acc1;
            this.acc2 = acc2;
            this.amout = amout;
        }

        @Override
        public void run() {
            if (acc1.getUserId() > acc2.getUserId()) {
                synchronized (acc2) {
                    if (acc1.getBalance() < amout) {
                        mailer.addToQ(0);

                        return;
                    }
                    synchronized (acc1) {

                        trans();
                    }
                }
            }

            else {
                synchronized (acc1) {
                    if (acc1.getBalance() < amout) {
                        mailer.addToQ(0);

                        return;
                    }
                    synchronized (acc2) {

                        trans();
                    }
                }
            }
        }

        private void trans () {
            acc1.setBalance(acc1.getBalance() - amout);
            acc2.setBalance(acc2.getBalance() + amout);

            mailer.addToQ(1);
        }
    }
}