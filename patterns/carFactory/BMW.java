package patterns.carFactory;

/**
 * Created by l1s on 19.04.17.
 */
public class BMW implements Car {
    @Override
    public boolean drive(int distance) {
        if (distance > 300)
            return false;
        return true;
    }
}
