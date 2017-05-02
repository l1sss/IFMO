package multiThreading.bar;

/**
 * Created by l1s on 01.05.17.
 */
public class Waiter implements Runnable {
    private Order order;

    public Waiter(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        System.out.println("Оффициант принял заказ...");
        try {
            Thread.sleep(1000);
            order.setInProgress(true);

            synchronized (order) {
                order.notify();

                while (!order.isReady())
                    order.wait();

                System.out.println("Оффициант выносит заказ...");
            }
        } catch (InterruptedException e) {
            System.out.println("Some error: " + e.getMessage());
        }
    }
}
