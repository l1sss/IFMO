package patterns.observer;

/**
 * Created by l1s on 23.04.17.
 */
public interface TempListener {

    void publish(String message);
}

interface GreenTempListener extends TempListener {
}

interface RedTempListener extends TempListener {
}

interface YellowTempListener extends TempListener {
}
