package multiThreading.bar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by l1s on 01.05.17.
 */
public class Order {
    private List<String> positions;
    private boolean ready;
    private boolean inProgress;

    public Order(String... val) {
        positions = new ArrayList<>();
        positions.addAll(Arrays.asList(val));
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }
}

