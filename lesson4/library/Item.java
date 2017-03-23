package lesson4.library;

/**
 * Created by l1s on 23.03.17.
 */
public class Item {
    private int counter;

    public void cntUp(int n) {
        counter += n;
    }

    public void cntDown(int n) {
        counter -= n;
    }

    public int getCounter() {
        return counter;
    }
}
