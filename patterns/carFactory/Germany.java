package patterns.carFactory;

/**
 * Created by l1s on 19.04.17.
 */
public class Germany extends Factory {
    private static Germany instance;

    private Germany(String region) {}

    public static Germany getInstance() {
        if (instance == null)
            instance = new Germany("Germany");

        return instance;
    }

    @Override
    Car createCar() {
        return new BMW();
    }
}