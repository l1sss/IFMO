package lesson7.LazyAccumulator;

import java.util.Stack;


public class LazyStackAccumulator {
    private Stack<Item> stack;
    private Stack<Item> rStack;
    private double value;

    public LazyStackAccumulator(Stack stack) {
        this.stack = stack;
    }

    public void add(double n, Operation operation) {
        stack.push(new Item(n, operation));
    }

    public double calculate() {
        rStack = new Stack<>();
        for (Item it : stack) {
            rStack.push(it);
        }

        for (Item it : rStack) {
            value = it.operation.apply(value, it.value);
        }

        return value;
    }

    private class Item<K, V> {
        double value;
        Operation operation;

         Item(double value, Operation operation) {
            this.value = value;
            this.operation = operation;
        }
    }
}
