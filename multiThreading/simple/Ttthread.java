package multiThreading.simple;

import collections.arrayList.ArrayList;

/**
 * Created by l1s on 28.04.17.
 */
public class Ttthread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        Thread thread3 = new Thread(new Thread3());

        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);

        for (Thread r : threads)
            r.start();

        Thread.sleep(5000);

        for (Thread r : threads)
            r.interrupt();

        thread3.join();
        System.out.println("\nEND!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

   static class Thread1 implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Run-run-run!");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

   static class Thread2 implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Go-go-go!");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

   static class Thread3 implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Alive-alive eee!");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}