package collections.accumulator;

/**
 * Created by l1s on 26.03.17.
 */
public class SquareRoot implements Operation {

    @Override
    public double apply(double a, int b) {
        return Math.sqrt(a);
    }
}
