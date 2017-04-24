package patterns.observer;

/**
 * Created by l1s on 23.04.17.
 */
public class President implements RedTempListener {
    @Override
    public void publish(String message) {
        System.out.println((char) 27 + "[31mБЕГИТЕ ГЛУПЦЫ!!!");
    }
}
