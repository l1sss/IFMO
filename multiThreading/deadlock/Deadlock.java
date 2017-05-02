package multiThreading.deadlock;

/**
 * Created by l1s on 01.05.17.
 */
public class Deadlock {
    public static void main(String[] args) {
       final Object o1 = new Object();
       final Object o2 = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        Thread.sleep(0,1);
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                    synchronized (o2) {
                        System.out.println("T1 locked all!");
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (o2) {
                    synchronized (o1) {
                        System.out.println("T2 locked all!");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}