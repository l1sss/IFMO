package lesson7.LazyAccumulator;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List list = new LinkedList();
        LazyListAccumulator llAcc = new LazyListAccumulator(list);
        Stack<Number> stack = new Stack<>();
        LazyStackAccumulator lsAcc = new LazyStackAccumulator(stack);

        llAcc.add(0, new Operation() {
            @Override
            public double apply(double a, double b) {
                return a * b;
            }
        });
        llAcc.add(3, new Operation() {
            @Override
            public double apply(double a, double b) {
                return a - b;
            }
        });

        System.out.println(llAcc.calculate() + "\n");

        lsAcc.add(0, new Operation() {
            @Override
            public double apply(double a, double b) {
                return a * b;
            }
        });
        lsAcc.add(3, new Operation() {
            @Override
            public double apply(double a, double b) {
                return a - b;
            }
        });

        System.out.println(lsAcc.calculate());
    }
}
