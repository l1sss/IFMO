package patterns.carFactory;

/**
 * Created by l1s on 19.04.17.
 */
public class Toyota implements Car {
    @Override
    public boolean drive(int distance) {
        if (distance > 250) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Toyota";
    }
}
