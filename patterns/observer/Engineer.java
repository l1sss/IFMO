package patterns.observer;

/**
 * Created by l1s on 23.04.17.
 */
public class Engineer implements YellowTempListener {
    @Override
    public void publish(String message) {
        System.out.println((char) 27 + "[33m" + message);
    }
}
