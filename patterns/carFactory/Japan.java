package patterns.carFactory;

/**
 * Created by l1s on 19.04.17.
 */
public class Japan extends Factory {
    private static Japan instance;

    private Japan(String region) {}

    public static Japan getInstance() {
        if (instance == null)
            instance = new Japan("Japan");

        return instance;
    }

    @Override
    Car createCar() {
        return new Toyota();
    }
}
