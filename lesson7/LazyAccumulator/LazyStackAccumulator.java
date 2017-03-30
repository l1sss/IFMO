package lesson7.LazyAccumulator;


import lesson4.linkedList.LinkedList;
import lesson4.linkedList.Stack;

/**
 * Created by l1s on 29.03.17.
 */
public class LazyStackAccumulator {
    private Stack stack;
    private Stack rStack;
    private double value;

    public LazyStackAccumulator(Stack stack) {
        this.stack = stack;
    }

    public void add(double n, Operation operation) {
        stack.push(new Item(n, operation));
    }

    public double calculate() {
        rStack = new LinkedList();
        for (Object o : stack) {
            rStack.push(o);
        }

        for (Object o : rStack) {
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
