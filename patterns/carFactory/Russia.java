package patterns.carFactory;

/**
 * Created by l1s on 19.04.17.
 */
public class Russia extends Factory {
    private static Russia instance;

    private Russia(String region) {}

    public static Russia getInstance() {
        if (instance == null)
            instance = new Russia("Russia");

        return instance;
    }

    @Override
    Car createCar() {
        return new Lada();
    }
}