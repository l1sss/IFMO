package control;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by l1s on 12.05.17.
 */
public class MailerThread implements Runnable {
    private BlockingQueue<Integer> resQ = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int result = resQ.take();

                switch (result) {
                    case 1:
                        System.out.println((char)27 + "[32moperation completed");
                        break;

                    case 0:
                        System.err.println("not enough money");
                        break;

                    case -1:
                        System.err.println("incorrect user");
                        break;

                    default:
                        System.err.println("something broke");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addToQ(int command) {
        resQ.offer(command);
    }
}