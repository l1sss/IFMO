package lesson7.LazyAccumulator;

import lesson4.linkedList.List;

/**
 * Created by l1s on 29.03.17.
 */
public class LazyListAccumulator {
    private List list;
    private double value;

    public LazyListAccumulator(List list) {
        this.list = list;
    }

    public void add(double n, Operation operation) {
        list.add(new Item(n, operation));
    }

    public double calculate() {
        for (Object o : list) {
            value = ((Item)o).operation.apply(value, ((Item)o).value);
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
