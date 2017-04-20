package patterns.carFactory;

/**
 * Created by l1s on 19.04.17.
 */
public class Germany extends Factory {
    String region = "Germany";

    @Override
    Car createCar() {
        return new BMW();
    }
}
