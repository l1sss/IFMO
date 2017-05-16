package multithreading.bar;

/**
 * Created by l1s on 01.05.17.
 */
public class Barmen extends Thread implements Runnable {
    private Order order;

    public Barmen(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        int cnt = (int) (Math.random() * (2000)) + 2000;

        synchronized (order) {
            try {
                while (!order.isInProgress())
                    order.wait();

                System.out.println("Бармен принял заказ...");

                Thread.sleep(cnt);
                order.setReady(true);

                order.notify();
            } catch (InterruptedException e) {
                System.out.println("Some error: " + e.getMessage());
            }
        }
    }
}
