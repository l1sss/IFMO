package patterns.carFactory;

/**
 * Created by l1s on 19.04.17.
 */
public class Japan extends Factory {
    String region = "Japan";

    @Override
    Car createCar() {
        return new Toyota();
    }
}
