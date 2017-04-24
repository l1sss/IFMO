package patterns.observer;

import collections.arrayList.ArrayList;
import collections.linkedList.List;

/**
 * Created by l1s on 23.04.17.
 */
public class Sensor {
    private List<GreenTempListener> greenListeners  = new ArrayList<>();
    private List<YellowTempListener> yellowListeners = new ArrayList<>();
    private List<RedTempListener> redListeners = new ArrayList<>();

    public void subscribe(TempListener listener) {
        if (listener instanceof GreenTempListener)
            greenListeners.add((GreenTempListener) listener);

        if (listener instanceof YellowTempListener)
            yellowListeners.add((YellowTempListener) listener);

        if (listener instanceof RedTempListener)
            redListeners.add((RedTempListener) listener);
    }

    public void unsubscribe(TempListener listener) {
        if (listener instanceof GreenTempListener)
            greenListeners.remove((GreenTempListener) listener);

        if (listener instanceof YellowTempListener)
            yellowListeners.remove((YellowTempListener) listener);

        if (listener instanceof RedTempListener)
            redListeners.remove((RedTempListener) listener);
    }

    public void newMessage(String message, Code code) {
        notifyListeners(message, code);
    }

    private void notifyListeners(String message, Code code) {
        switch (code) {

            case GREEN:
                for (GreenTempListener listener : greenListeners) {
                    listener.publish(message);
                }
                break;

            case YELLOW:
                for (YellowTempListener listener : yellowListeners) {
                    listener.publish(message);
                }
                break;

            case RED:
                for (RedTempListener listener : redListeners) {
                    listener.publish(message);
                }
                break;
        }
    }
}