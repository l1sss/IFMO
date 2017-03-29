package lesson7.AnonimAccumulator;

/**
 * Created by l1s on 28.03.17.
 */
public class AnonimAccumulator {
    private double value;
    private Operation operation;

    public AnonimAccumulator(double value, Operation operation) {
        this.value = value;
        this.operation = operation;
    }

    public void calculate(int n) {
        value = operation.apply(value, n);
    }

    public double getValue() {
        return value;
    }
}
