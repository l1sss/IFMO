package lesson5.Accumulator;

/**
 * Created by l1s on 24.03.17.
 */
public class Plus extends Operation {
    @Override
    public double apply(double a, int b) {
        return a + b;
    }

    @Override
    public double apply(double a, long b) {
        return a + b;
    }

    @Override
    public double apply(double a, double b) {
        return a + b;
    }
}
