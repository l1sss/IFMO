package patterns.factory;

/**
 * Created by l1s on 19.04.17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Russia rus = Russia.getInstance();
        Car car = Factory.getFactory("Russia").createCar();
        Car car2 = Factory.getFactory("Japan").createCar();

        System.out.println(rus);
        System.out.println(car);
        System.out.println(car2);
    }
}
