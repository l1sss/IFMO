package multiThreading.bar;

/**
 * Created by l1s on 01.05.17.
 */
public class Bar {
    public static void main(String[] args) throws InterruptedException {
        Order order = new Order("Beer");

        Thread waiter = new Thread(new Waiter(order));
        waiter.start();

        Thread barmen = new Thread(new Barmen(order));
        barmen.start();

        waiter.join(3000);

        if(order.isReady()) {
            Thread.sleep(1000);
            System.out.println((char) 27 + "[32mКлиент доволен!" + (char) 27 + "[0m");
        } else
            System.out.println((char) 27 + "[31mСлишком долго, клиент не доволен!" + (char) 27 + "[0m");
    }
}
