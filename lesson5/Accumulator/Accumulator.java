package lesson5.Accumulator;

/**
 * Created by l1s on 24.03.17.
 */
public class Accumulator {
    private Operation operation;
    private double value;

    public Accumulator(Operation operation, double value) {
        this.operation = operation;
        this.value = value;
    }

    public Accumulator(Operation operation) {
        this.operation = operation;
    }

    public void calculate(double d) {
        value = operation.apply(value, d);
    }

    public double getValue() {
        return value;
    }
}
