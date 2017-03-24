package lesson5.Accumulator;

/**
 * Created by l1s on 24.03.17.
 */
public class Accumulator {
    private double value;
    private Operation operation;

    public Accumulator(Operation operation) {
        this.operation = operation;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void calculate(double d) {
        value = operation.apply(value, d);
    }

    public double getValue() {
        return value;
    }
}
