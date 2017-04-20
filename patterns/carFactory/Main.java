package patterns.carFactory;

/**
 * Created by l1s on 19.04.17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Russia rus = Russia.getInstance();
        Germany ger = Germany.getInstance();

        Car car = Factory.getFactory("Russia").createCar();

        System.out.println(ger.createCar().drive(2));

        System.out.println(car);
    }
}
