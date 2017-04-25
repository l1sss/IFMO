package patterns.factory;

/**
 * Created by l1s on 19.04.17.
 */
public interface Car {
    boolean drive(int distance);
}

class BMW implements Car {
    @Override
    public boolean drive(int distance) {
        if (distance > 300)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BMW";
    }
}

class Lada implements Car {
    @Override
    public boolean drive(int distance) {
        return false;
    }

    @Override
    public String toString() {
        return "Hellish chariot";
    }
}

class Toyota implements Car {
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