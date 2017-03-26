package lesson5.Accumulator;

/**
 * Created by l1s on 24.03.17.
 */
public class Plus implements Operation {
    @Override
    public double apply(double a, int b) {
        return a + b;
    }
}
