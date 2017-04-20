package collections.accumulator.lazyAccumulator;

import java.util.List;

/**
 * Created by l1s on 29.03.17.
 */
public class LazyListAccumulator {
    private List<Item> list;
    private double value;

    public LazyListAccumulator(List<Item> list) {
        this.list = list;
    }

    public void add(double n, Operation operation) {
        list.add(new Item(n, operation));
    }

    public double calculate() {
        for (Item it : list) {
            value = it.operation.apply(value, (it.value));
        }
        return value;
    }

    private class Item {
        double value;
        Operation operation;

        public Item(double value, Operation operation) {
            this.value = value;
            this.operation = operation;
        }
    }
}
