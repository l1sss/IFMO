package lesson5.Accumulator;

/**
 * Created by l1s on 26.03.17.
 */
public class Mod implements Operation{
    @Override
    public double apply(double a, int b) {
        return a % b;
    }
}
