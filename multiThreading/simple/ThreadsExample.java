package multiThreading.simple;

/**
 * Created by xmitya on 26.04.17.
 */
public class ThreadsExample {
    public static void main(String[] args) {
        Thread myThread = new Thread(new MyThread());
        myThread.start();
        System.out.println("Конец работы главного потока");
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Привет с побочного потока!");
    }
}
