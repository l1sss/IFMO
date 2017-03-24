package lesson5.Accumulator;

/**
 * Created by l1s on 24.03.17.
 */
public class Pow extends Operation {
    @Override
    public double apply(double a, int b) {
        return Math.pow(a, b);
    }

    @Override
    public double apply(double a, long b) {
        return Math.pow(a, b);
    }

    @Override
    public double apply(double a, double b) {
        return Math.pow(a, b);
    }
}
