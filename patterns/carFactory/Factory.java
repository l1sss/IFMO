package patterns.carFactory;

/**
 * Created by l1s on 19.04.17.
 */
public abstract class Factory {
    String region;

    abstract Car createCar();

    public static Factory getFactory(String region) throws Exception {
        switch (region) {
            case "Russia":
                return Russia.getInstance();
            case "Germany":
                return new Germany();
            case "Japan":
                return new Japan();
        }
        throw new Exception("Invalid region!");
    }
}
