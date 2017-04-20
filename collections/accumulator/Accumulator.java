package collections.accumulator;

/**
 * Created by l1s on 24.03.17.
 */
public class Accumulator {
    private double[] value;
    private Operation[] operation;

    public Accumulator(double[] value, Operation[] operation) {
        this.value = value;
        this.operation = operation;
    }

    public void calculate(int n) {
        for (int i = 0; i < value.length; i++) {
            value[i] = operation[i].apply(value[i], n);
        }
    }

    public double[] getValue() {
        return value;
    }
}
