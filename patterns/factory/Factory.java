package patterns.factory;

/**
 * Created by l1s on 19.04.17.
 */
public abstract class Factory {

    abstract Car createCar();

    public static Factory getFactory(String region) throws Exception {
        switch (region) {
            case "Russia":
                return Russia.getInstance();
            case "Germany":
                return Germany.getInstance();
            case "Japan":
                return Japan.getInstance();
        }
        throw new Exception("Invalid region!");
    }
}

class Germany extends Factory {
    private static Germany instance;

    private Germany() {
    }

    public static Germany getInstance() {
        if (instance == null)
            instance = new Germany();

        return instance;
    }

    @Override
    Car createCar() {
        return new BMW();
    }
}

class Japan extends Factory {
    private static Japan instance;

    private Japan() {
    }

    public static Japan getInstance() {
        if (instance == null)
            instance = new Japan();

        return instance;
    }

    @Override
    Car createCar() {
        return new Toyota();
    }
}

class Russia extends Factory {
    private static Russia instance;

    private Russia() {
    }

    public static Russia getInstance() {
        if (instance == null)
            instance = new Russia();

        return instance;
    }

    @Override
    Car createCar() {
        return new Lada();
    }

    @Override
    public String toString() {
        return "Mordor factory";
    }
}
